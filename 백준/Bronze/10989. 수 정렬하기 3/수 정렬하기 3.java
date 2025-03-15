import java.io.*;
import java.util.Objects;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int n = Integer.parseInt(bf.readLine());
       int[] arr = new int[n];
       for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
       }

       Arrays.sort(arr);

       for(int i=0;i<n;i++){
           bw.write(arr[i]+"\n");
       }
       bw.close();


    }
}