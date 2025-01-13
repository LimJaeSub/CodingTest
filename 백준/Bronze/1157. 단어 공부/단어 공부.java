import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String input = bf.readLine(); // 글자 입력받음
        String[] parts = input.split(""); // 단어 나눠서 알파벳별로 분리

        Map<String,Integer> resultmap = new HashMap<>();

        for(int i=0;i<parts.length;i++){
            String nowword = parts[i].toUpperCase();
            //현재 맵에 단어가 있는지 확인
            if(resultmap.containsKey(nowword)){
                // true : 단어가 있을 경우 키값을 하나 증가시켜줌
                // 우선 값을 가져온뒤에
                // put을 이용해 값을 증가시킨다

                // 키 값 업데이트 등의 복잡한 로직에서 compute() 사용
                resultmap.compute(nowword, (key, prev) -> prev + 1);
            }
            else{
                // false : 단어가 아직 map에 없음
                resultmap.put(nowword,1);
            }

        }

        // 가장 많이나온 단어 갯수 찾기
        int max = Integer.MIN_VALUE;
        for(String key:resultmap.keySet()){
            //bw.write(key);
            int tmp = resultmap.get(key);
            //bw.write(tmp+"");
            if(tmp>max){
                max=tmp;
            }
        }


        // 
        boolean check = false;
        String answer = "";
        for(String key:resultmap.keySet()){
            // 최댓값이랑 같은 키를 찾았을 때
            if(resultmap.get(key).equals(max)){
                // 체크 변수가 false일 경우(아직 최대 단어를 찾이 못했음)
                if(!check){
                    // 답변에 정답 키값을 넣어주고
                    answer=key;
                    // check변수를 true로 바꿔준다.
                    check=true;
                }
                // 이부분은 check가 true 인 경우(답변에 이미 답이 들어가있음) 같은 숫자가 나온 의미이므로
                // 알파벳이 여러 개 존재한다는 뜻이다.
                else{
                    // 따라서 ? 출력후 for문 break;
                    answer="?";
                    break;
                }
            }
        }
        
        
        bw.write(answer);


        bw.flush();
        bw.close();

    }
}