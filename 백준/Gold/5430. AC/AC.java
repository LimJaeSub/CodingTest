import java.util.*;
import java.io.*;

public class Main {
    public static void AC(String[] func,int arrlen,String arr){
        // 1. 배열 정제하기
        List<Integer> result = new ArrayList<>();
        String arr3 = arr.substring(1,arr.length()-1);
        if(!arr3.isEmpty()){
            int[] arr2 = Arrays.stream(arr3.split(","))
                    .mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<arrlen;i++){
                result.add(arr2[i]);
            }
        }

        // 2. 함수 기능
        int first = 0;
        int last = result.size()-1;
        boolean rev = false;

        for(int i=0;i<func.length;i++){
            switch(func[i]){
                case "R" :
                    rev = !rev;
                    break;
                case "D" :
                    if(result.isEmpty()){
                        System.out.println("error");
                        return; // 에러 발생 → 바로 종료
                    } else {
                        if(rev){
                            result.remove(last);
                        } else {
                            result.remove(first);
                        }
                        last--;
                    }
                    break;
                default :
                    break;
            }
        }

        // 3. 뒤집기 처리
        if(rev){
            while(first<=last){
                int tmp = result.get(last);
                result.set(last,result.get(first));
                result.set(first,tmp);
                first++;
                last--;
            }
        }

        // 4. 출력 (공백 없는 포맷)
        StringBuilder out = new StringBuilder();
        out.append('[');
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) out.append(',');
            out.append(result.get(i));
        }
        out.append(']');
        System.out.println(out.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            String[] func = bf.readLine().split("");
            int arrlen = Integer.parseInt(bf.readLine());
            String arr = bf.readLine();
            AC(func,arrlen,arr);
        }
    }
}
