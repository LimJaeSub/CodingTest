import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] card = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(bf.readLine());
        int[] num = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] checkarr = new int[M];

        Set<Integer> cardset = new HashSet<>(); // 가지고 있는 카드를 순회해야하니까 card로 set 만듬
        for(int i : card){
            cardset.add(i);
        }

        for(int i=0;i<M;i++){
            if(cardset.contains(num[i])){
                checkarr[i] = 1;
            }
            else{
                checkarr[i] = 0;
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i : checkarr){
            sb.append(i).append(" ");
        }

        System.out.println(sb);



    }
}