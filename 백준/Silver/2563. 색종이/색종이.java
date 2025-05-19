import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 색종이 크기 10x10

        int[][] white = new int[101][101];
        int TC = Integer.parseInt(bf.readLine());

        for(int i=0;i<TC;i++){
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int left = input[0];
            int down = input[1];

            for(int j=left;j<left+10;j++){
                for(int k=down;k<down+10;k++){
                    white[j][k] = 1;
                }
            }
        }
        int answer = 0;
        for(int i=1;i<101;i++){
            for(int j=1;j<101;j++)
                if(white[i][j]==1)	//true일 때
                    answer++;
        }

        System.out.println(answer);
    }
}