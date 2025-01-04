import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] numarr = new Integer[9];
        for(int i=0;i<numarr.length;i++){
            String input = bf.readLine();
            numarr[i]=Integer.parseInt(input);
        }
        int max = Arrays.stream(numarr).max(Integer::compare).get();
        int maxindex = Arrays.asList(numarr).indexOf(max);
        bw.write(max+"\n");
        bw.write(maxindex+1+"");


        bw.flush();
        bw.close();




    }
}