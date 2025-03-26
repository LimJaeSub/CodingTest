import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0; i<tc; i++){
            String input = bf.readLine();
            int[] parts = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int H = parts[0];
            int W = parts[1];
            int N = parts[2];

            int roomnumcal = N%H==0 ? N/H : (N/H)+1;

            String roomnum = roomnumcal<10 ? 0+""+roomnumcal : roomnumcal+"";
            int floornum = N%H==0 ? H : N%H;

            bw.write(floornum+roomnum+"\n");
        }
        bw.flush();
        bw.close();

    }
}