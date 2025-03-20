import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bf.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int j = Integer.parseInt(input[1]);

        String answer = "";

        int checknum = 1;

       while(checknum>0){
            int k = n/j;
            int d = n%j;
            checknum=k;
            String std = "";

            if(d>=10){
                std = String.valueOf((char) (d+55));
            }
            else{
                std =std+ d;
            }

            answer = std+answer;
            n=k;
        }

        bw.write(answer);


        bw.flush();
        bw.close();




    }
}