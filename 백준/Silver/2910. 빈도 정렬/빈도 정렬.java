import java.util.*;
import java.io.*;


// 2910
public class Main {
    // 정보 클래스
    static class Info{
        int num;
        int count;
        int order;

        Info(int num,int count,int order){
            this.num = num;
            this.count = count;
            this.order = order;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        String[] input1 = bf.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int C = Integer.parseInt(input1[1]);


        int[] number = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedHashMap<Integer,Info> map = new LinkedHashMap<>();

        int idx = 0;
        for(int i=0;i<number.length;i++){
            if(map.containsKey(number[i])){
                // 이미 map에 있을 경우, number[i]를 키 값으로 가지고 있는 Info의 count값을 증가시켜줌
                map.get(number[i]).count++;
            }
            else{
                // map에 없을 경우 number[i]를 키 값으로 가지고 있는 정보를 업데이트 해줌
                map.put(number[i], new Info(number[i],1,idx++));
            }
        }

        // Info로 구성된 list를 만들어줌
        List<Info> list = new ArrayList<>(map.values());

        list.sort((a, b) -> {
            if (b.count == a.count) { // 같은 갯수일 경우
                return a.order-b.order; // 먼저 나온 값 출력(음수가 나와야 idx가 작은 값이 먼저 나오게 됨,a.order가 먼저 오는거)
            }
            return Integer.compare(b.count, a.count); // count 큰 게 먼저
        });

        StringBuilder sb = new StringBuilder();
        for(Info info : list){
            for(int i=0;i<info.count;i++){
                sb.append(info.num).append(" ");
            }
        }

        System.out.print(sb);

    }
}