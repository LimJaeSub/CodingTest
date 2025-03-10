import java.io.*;
import java.util.Objects;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        String[] size = input.split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        String[] castle = new String[n];

        for(int i=0;i< castle.length;i++){
            String input2 = bf.readLine();
            castle[i] = input2;
        }

        // 가로축
        int count_n = 0;
        for(int i=0;i<n;i++){
            if(castle[i].indexOf('X')<0){ // 경비병이 없다는 소리임
                count_n++;
            }
        }
        // 세로축
        int count_m = 0;
        boolean man = true;
        for(int i=0;i<m;i++){
            int checknum=0;
            for(int j=0;j<n;j++){
                if(castle[j].charAt(i)=='X'){ // 경비병이 없다는 소리임
                    break;
                }
                checknum++;

            }
            if(checknum==n){
                count_m++;
            }
        }

        int answer = Math.max(count_n, count_m);




        bw.write(answer+"");
        bw.flush();
        bw.close();



    }
}