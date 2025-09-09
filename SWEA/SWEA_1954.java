import java.util.*;
import java.io.*;

public class SWEA_1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            int N = Integer.parseInt(bf.readLine());
            int[][] snail = new int[N][N];

            int x = 0;
            int y = 0;

            String[] dir = {"front","down","back","up"};

            int movecount = N-1; // 내려가는것부터 시작할꺼니까 하나 빼줌
            int mainmovecount = N-1;
            int usemc = 2;
            int checkdirindex = 1; //이번엔 어떤 방향인지 확인하는 인덱스

            for(int j=1;j<=N*N;j++){
                // 1. 방향(상하좌우) 탐색
                // 2. 해당 방향으로 몇번 행해야하는지
                // [0][n] 이면 무조건 N만큼 이동
                if(x==0 && y<N){
                    // 가장 윗줄일 경우
                    snail[x][y] = j;
                    y++;
                }
                else{
                    if(x==0 && y==N){
                        y=y-1;
                    }

                    switch(dir[checkdirindex]){
                        // 전방 이동 (x값 그대로 y값 증가)
                        case "front" :
                            if(usemc>0){
                                // 누적 mc의 사용량이 남았을 경우
                                if(movecount>0){
                                    // mc 사용량이 남았을 경우
                                    y=y+1;
                                    snail[x][y] = j;
                                    movecount--;
                                }
                                else{
                                    // mc 사용량 끝남(방향바꿔주기)
                                    // movecount 다시 채우기
                                    // 누적mc 하나 지우기
                                    movecount = mainmovecount;
                                    checkdirindex++;
                                    usemc--;
                                    j--;
                                }
                            }
                            else{
                                // 누적 mc의 사용량이 없을 경우
                                // 움직임의 수를 하나 줄이고 누적횟수를 2개 만듬
                                mainmovecount = mainmovecount-1;
                                movecount=mainmovecount;
                                usemc = 2;
                                j--;
                            }

                            break;


                        // 하향 이동 (y값 그대로 x값 증가)
                        case "down" :
                            if(usemc>0){
                                // 누적 mc의 사용량이 남았을 경우
                                if(movecount>0){
                                    // mc 사용량이 남았을 경우
                                    x=x+1;
                                    snail[x][y] = j;
                                    movecount--;
                                }
                                else{
                                    // mc 사용량 끝남(방향바꿔주기)
                                    // movecount 다시 채우기
                                    // 누적mc 하나 지우기
                                    movecount = mainmovecount;
                                    checkdirindex++;
                                    usemc--;
                                    j--;
                                }
                            }
                            else{
                                // 누적 mc의 사용량이 없을 경우
                                // 움직임의 수를 하나 줄이고 누적횟수를 2개 만듬
                                mainmovecount = mainmovecount-1;
                                movecount=mainmovecount;
                                usemc = 2;
                                j--;
                            }

                            break;

                        // 후방 이동(x값 그대로 y값 감소)
                        case "back" :
                            if(usemc>0){
                                // 누적 mc의 사용량이 남았을 경우
                                if(movecount>0){
                                    // mc 사용량이 남았을 경우
                                    y=y-1;
                                    snail[x][y] = j;
                                    movecount--;
                                }
                                else{
                                    // mc 사용량 끝남(방향바꿔주기)
                                    // movecount 다시 채우기
                                    // 누적mc 하나 지우기
                                    movecount = mainmovecount;
                                    checkdirindex++;
                                    usemc--;
                                    j--;
                                }
                            }
                            else{
                                // 누적 mc의 사용량이 없을 경우
                                // 움직임의 수를 하나 줄이고 누적횟수를 2개 만듬
                                mainmovecount = mainmovecount-1;
                                movecount=mainmovecount;
                                usemc = 2;
                                j--;
                            }

                            break;
                        // 상향 이동(y값 그대로 x값 감소)
                        case "up" :
                            if(usemc>0){
                                // 누적 mc의 사용량이 남았을 경우
                                if(movecount>0){
                                    // mc 사용량이 남았을 경우
                                    x=x-1;
                                    snail[x][y] = j;
                                    movecount--;
                                }
                                else{
                                    // mc 사용량 끝남(방향바꿔주기)
                                    // movecount 다시 채우기
                                    // 누적mc 하나 지우기
                                    movecount = mainmovecount;
                                    // 상향 이동은 마지막 인덱스라 다시 0으로 바꿔줌(전방)
                                    checkdirindex=0;
                                    usemc--;
                                    j--;
                                }
                            }
                            else{
                                // 누적 mc의 사용량이 없을 경우
                                // 움직임의 수를 하나 줄이고 누적횟수를 2개 만듬
                                mainmovecount = mainmovecount-1;
                                movecount=mainmovecount;
                                usemc = 2;
                                j--;
                            }

                            break;
                    }

                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append("\n");
            for(int w=0;w<N;w++){
                for(int v=0;v<N;v++){
                    sb.append(snail[w][v]);

                    if(v==N-1 && w<N-1){
                        sb.append("\n");
                    }
                    else{
                        sb.append(" ");
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
