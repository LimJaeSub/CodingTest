import java.util.*;
import java.io.*;


class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            int[] NM = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = NM[0];
            int M = NM[1];

            List<Integer> catchfly = new ArrayList<>();

            int[][] fly = new int[N][N];
            for(int j=0;j<N;j++){
                int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k=0;k<N;k++){
                    fly[j][k] = input[k];
                }
            }

            // 열
            for(int j=0;j<=N-M;j++){
                // 행
                for(int k=0;k<=N-M;k++){
                    // 파리채 구역 돌기
                    int catchcount = 0;
                    for(int w=j;w<j+M;w++){
                        for(int v=k;v<k+M;v++){
                            catchcount = catchcount+fly[w][v];
                        }
                    }
                    catchfly.add(catchcount);
                }
            }
            Collections.sort(catchfly);
            System.out.println("#"+(i+1)+" "+catchfly.get(catchfly.size()-1));


        }
    }
}
