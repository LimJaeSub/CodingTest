import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> circle = new LinkedList<>();
        ArrayList<Integer> yose = new ArrayList<>();
        int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int K = input[1];

        for(int i=1;i<=N;i++){
            circle.add(i);
        }

        while(!circle.isEmpty()){
            for(int i=0;i<K;i++){
                int num = circle.poll();
                if(i==K-1){
                    // 진짜 큐에서 빼낼 수
                    yose.add(num);
                }
                else{
                    // 다시 큐로 집어넣을 수
                    circle.add(num);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0;i<yose.size();i++){
            sb.append(yose.get(i));
            if(!Objects.equals(i,yose.size()-1)){
                sb.append(",").append(" ");
            }
        }
        sb.append(">");

        System.out.println(sb);




    }
}
