import java.util.*;
import java.io.*;


public class SWEA_1979 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = input[0];
            int K = input[1];

            int[][] table = new int[N][N];
            for(int j=0;j<N;j++){
                int[] tableinput = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k=0;k<tableinput.length;k++){
                    table[j][k] = tableinput[k];
                }
            }

            // 0이 칠해진 칸, 1이 빈칸

            int resultcount = 0;
            // K가 1인 특수한 케이스일 경우
            if(K==1){
                for(int row=0;row<N;row++){
                    for(int col=0;col<N;col++){
                        if(table[row][col]==1){
                            // 빈칸일 경우인데 K가 1일경우는 상하좌우가 빈칸이 아닌지 확인해야함.

                            // 좌측 끝칸일 경우
                            if(col==0){
                                if(row==0){
                                    // 맨윗칸
                                    if(table[row+1][col]==0 && table[row][col+1]==0){
                                        resultcount++;
                                    }
                                }
                                else if(row==N-1){
                                    // 맨아랫칸
                                    if(table[row-1][col]==0 && table[row][col+1]==0){
                                        resultcount++;
                                    }
                                }
                                else{
                                    if(table[row+1][col]==0 && table[row-1][col]==0 && table[row][col+1]==0){
                                        resultcount++;
                                    }
                                }
                            }
                            // 우측 끝칸일 경우
                            else if(col==N-1){
                                if(row==0){
                                    // 맨윗칸
                                    if(table[row+1][col]==0 && table[row][col-1]==0){
                                        resultcount++;
                                    }
                                }
                                else if(row==N-1){
                                    // 맨아랫칸
                                    if(table[row-1][col]==0 && table[row][col-1]==0){
                                        resultcount++;
                                    }
                                }
                                else{
                                    if(table[row+1][col]==0 && table[row-1][col]==0 && table[row][col-1]==0){
                                        resultcount++;
                                    }
                                }
                            }
                            else{
                                // 끝칸이 아닌 가운데 있을 경우
                                if(row==0){
                                    // 맨윗칸
                                    if(table[row+1][col]==0 && table[row][col-1]==0 && table[row][col+1]==0){
                                        resultcount++;
                                    }
                                }
                                else if(row==N-1){
                                    // 맨아랫칸
                                    if(table[row-1][col]==0 && table[row][col-1]==0 && table[row][col+1]==0){
                                        resultcount++;
                                    }
                                }
                                else{
                                    if(table[row+1][col]==0
                                    && table[row-1][col] ==0
                                    && table[row][col+1]==0
                                    && table[row][col-1]==0){
                                      resultcount++;
                                    }
                                }

                            }
                        }
                    }
                }
            }
            else{
                // 세로 검사
                for(int col=0; col<N;col++){
                    int isOk = 0;
                    for(int row=0;row<N;row++){
                        if(table[row][col]==1){
                            // 문자를 넣을 수 있는 칸
                            isOk++;

                            // K칸됐는데 아직 뒤에 칸이 있을경우?
                            // 1. 뒤에칸이 문자를 넣을 수 있을경우 > 실패
                            // 2. 뒤에칸이 문자를 넣을 수 없는경우(0이거나 끝칸이거나) >성공
                            if(isOk==K) {
                                if (row < N - 1) {
                                    // 끝칸이 아닐 경우
                                    if (table[row + 1][col] == 1) {
                                        // 흰색 부분일 경우 isOk초기화
                                        isOk = 0;
                                    } else {
                                        // 흰색 부분이 아닐 경우 > 완성
                                        resultcount++;

                                    }
                                } else {
                                    // 현재 끝칸일 경우 > 완성
                                    resultcount++;

                                }
                                // 어떤 경우든 isOk가 K칸이 되면 해당 변수를 0으로 초기화
                                isOk = 0;
                            }
                        }
                        else{
                            // 문자를 넣지 못하는 칸
                            isOk=0;
                        }
                    }
                }

                // 가로 검사(세로로 내려와야함)
                for(int row=0; row<N;row++){
                    int isOk = 0;
                    for(int col=0;col<N;col++){
                        if(table[row][col]==1){
                            // 문자를 넣을 수 있는 칸
                            isOk++;

                            // K칸됐는데 아직 뒤에 칸이 있을경우?
                            // 1. 뒤에칸이 문자를 넣을 수 있을경우 > 실패
                            // 2. 뒤에칸이 문자를 넣을 수 없는경우(0이거나 끝칸이거나) >성공
                            if(isOk==K){
                                if(col<N-1){
                                    // 끝칸이 아닐 경우
                                    if(table[row][col+1]==1){
                                        // 흰색 부분일 경우 isOk초기화
                                        isOk=0;
                                    }
                                    else{
                                        // 흰색 부분이 아닐 경우 > 완성
                                        resultcount++;

                                    }
                                }
                                else{
                                    // 현재 끝칸일 경우 > 완성
                                    resultcount++;

                                }
                                // 어떤 경우든 isOk가 K칸이 되면 해당 변수를 0으로 초기화
                                isOk=0;
                            }

                        }
                        else{
                            // 문자를 넣지 못하는 칸
                            isOk=0;
                        }
                    }
                }

            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append(" ").append(resultcount);

            System.out.println(sb);



        }
    }
}
