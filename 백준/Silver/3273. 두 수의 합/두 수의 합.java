import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = Integer.parseInt(bf.readLine());

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],answer-arr[i]);
        }

        int count=0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(answer-arr[i])){
                count++;
            }
        }

        bw.write(count/2+"");
        bw.flush();
        bw.close();


    }
}
