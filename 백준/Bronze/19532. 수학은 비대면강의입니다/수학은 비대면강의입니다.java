import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int x1 = arr[0]; // x
        int y1 = arr[1]; // y
        int func1 = arr[2]; // 상수항

        int x2 = arr[3]; // x
        int y2 = arr[4]; // y
        int func2 = arr[5]; // 상수항

        int D = x1*y2-y1*x2;

        int find_x = (y2*func1 - y1*func2)/D;
        int find_y = (x1*func2 - x2*func1)/D;




        StringBuilder sb = new StringBuilder();
        sb.append(find_x).append(" ").append(find_y);

        System.out.println(sb);




    }
}