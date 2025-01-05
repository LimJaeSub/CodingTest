import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        String[] parts = input.split(" "); // 두개 입력받기

        int basket = Integer.parseInt(parts[0]); // 바구니 갯수
        int count = Integer.parseInt(parts[1]); // 공 넣는 수

        int[] answer = new int[basket]; // 정답 배열

        for(int i=0;i<count;i++){
            String howball = bf.readLine();
            int[] howballparts = Arrays.stream(howball.split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=howballparts[0]-1;j<=howballparts[1]-1;j++){
                answer[j]=howballparts[2];
            }

        }
        String result = Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bw.write(result);
        bw.flush();
        bw.close();


    }
}