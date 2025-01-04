import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        int[] parts = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max;
        if(parts[0]<0){
            max=parts[0];
        }
        else{
            max=0;
        }

        int min=parts[0];
        for(int i=0;i<tc;i++){
            if(parts[i]>max){
                max=parts[i];
            }
            else if(parts[i]<min){
                min=parts[i];
            }
        }
        bw.write(min+" "+max);
        bw.flush();
        bw.close();

    }
}