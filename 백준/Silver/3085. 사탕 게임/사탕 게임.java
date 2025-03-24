import java.io.*;
import java.util.*;


public class Main {

    public static void swap(String[][] tmp,int a1,int b1,int a2,int b2){

        String tmp1 = tmp[a1][b1];
        tmp[a1][b1] = tmp[a2][b2];
        tmp[a2][b2] = tmp1;
    }

    public static int check(String[][] tmp,int N){
        int max_count = 0;
        // 가로로 탐색
        for(int i=0;i<N;i++){
            int count = 1;
            for(int j=0;j<N-1;j++) {
                if(Objects.equals(tmp[i][j], tmp[i][j + 1])){
                    count++;
                    max_count = Math.max(count,max_count);
                }
                else{
                    count = 1;
                }
            }

        }

        //세로로 탐색
        for(int i=0;i<N;i++){
            int count = 1;
            for(int j=0;j<N-1;j++){
                if(Objects.equals(tmp[j][i],tmp[j+1][i])){
                    count++;
                    max_count = Math.max(count,max_count);
                }
                else{
                    count =1;
                }

            }
        }

        return max_count;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        String[][] map = new String[N][N];


        // 입력값 2차원배열에 넣기
        for(int i=0;i<N;i++){
            String a = bf.readLine();
            String[] line = a.split("");
            map[i] = line;
        }

        // 1. 변환할 내용이 같으면 변환x
        // 2. 한 줄이 모두 같으면 정답 N 출력
        // 3. 끝에는 굳이 검사 안 해도 됨

        String[][] tmp = map;
        int max_count =0;


        // 가로 교환
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                // 사탕 교환 (가로줄)
                swap(tmp,i,j,i,j+1);

                // 갯수 체크
                int max = check(tmp,N);
                if(max>max_count){
                    max_count=max;
                }


                // 배열 돌려놓기
                swap(tmp,i,j,i,j+1);
            }
        }

        //세로 교환
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                swap(tmp,i,j,i+1,j);

                int max = check(tmp,N);
                if(max>max_count){
                    max_count=max;
                }

                // 배열 돌려놓기
                swap(tmp,i,j,i+1,j);
            }

        }

        bw.write(max_count+"");
        bw.flush();
        bw.close();

    }
}