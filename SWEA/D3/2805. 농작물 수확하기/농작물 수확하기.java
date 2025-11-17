import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for(int i=0;i<tc;i++){
            int N = Integer.parseInt(bf.readLine());
            int[][] farm = new int[N][N];
            int result = 0;
            // 농장에 농작물 심기
            for(int j=0;j<N;j++){
                farm[j] = Arrays.stream(bf.readLine().split(""))
                        .mapToInt(Integer::parseInt).toArray();
            }
            int center = N/2;
            int temp = N-1;
            int start = 1;

            // 가운데 제외 전부 계산
            for(int check = 1; check<=center; check++){
                // 해당 열(가로) 계산하는 for문
                for(int row=start;row<temp;row++){
                    result = result+farm[center-check][row]+farm[center+check][row];
                }
                // 가로 다 돌았으면 temp는 -1,start는 +1
                temp--;
                start++;
            }

            // 가운데 쪽 계산
            for(int a=0;a<N;a++){
                result = result+farm[center][a];
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append(" ").append(result);
            System.out.println(sb);

        }


    }
}