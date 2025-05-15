import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String N = bf.readLine();
        int num_N = Integer.parseInt(N);

        int result = 0;
        for (int i = 1; i <= num_N; i++) {
            int[] arr = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            int sum = i;
            for (int j = 0; j < arr.length; j++) {
                sum = sum + arr[j];
            }
            
            if (sum == num_N) {
                result = i;
                break;
            }

        }

        System.out.println(result);


    }
}