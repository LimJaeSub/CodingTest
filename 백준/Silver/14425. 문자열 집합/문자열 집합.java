import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] part = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = part[0];
        int M = part[1];

        Set<String> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            S.add(input);
        }

        List<String> K = new LinkedList<>();
        for(int i=0;i<M;i++){
            String input = bf.readLine();
            K.add(input);
        }
        int count = 0;
        for(String str : K){
            if(S.contains(str)){
                count++;
            }
        }



        System.out.println(count);

    }
}