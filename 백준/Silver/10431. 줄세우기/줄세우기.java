import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());


        for(int i=0;i<tc;i++){
            String input = bf.readLine();
            int[] student = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); // 새로 안 문법
            int movecount = 0;
            for(int j=1;j<student.length;j++){
                for(int k=1;k<j;k++){
                    if(student[k]>student[j]){ // 처음부터 j 까지 애들 중 student[j]보다 큰 애들만 한발짝 물러서면됨
                        movecount++;
                    }
                }
            }
            bw.write(i+1+" "+movecount+"\n");
        }
        bw.close();

    }
}