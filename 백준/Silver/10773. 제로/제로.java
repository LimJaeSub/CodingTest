import java.util.*;
import java.io.*;


public class Main {
        static List<Integer> num = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(bf.readLine());

        for(int i=0;i<K;i++){
            int input = Integer.parseInt(bf.readLine());
            if(input==0 && !num.isEmpty()){
                num.remove(num.size()-1);
            }
            else{
                num.add(input);
            }
        }
        int answer = 0;
        for(int i : num){
            answer+=i;
        }

        System.out.println(answer);
    }
}