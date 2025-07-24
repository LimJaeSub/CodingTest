import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static boolean[][] visited; // 방문 배열
    static int[][] map;


    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void bfs(int row,int col){
        Queue<int[]> queue = new LinkedList<>();
        // bfs용도로 사용할 큐 생성
        // * queue에는 방문 예정인 좌표를 입력해야됨 !

        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            // queue가 빌 때까지 반복
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];


                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;

                        map[nx][ny] = map[cx][cy] + 1; // 거리 누적하기
                    }
                }
            }
        }




    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] target = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = target[0]; // 행
        M = target[1]; // 열

        // 1. 방문 배열 초기화
        visited = new boolean[N][M];
        map = new int[N][M];

        // 2. 지도 저장
        for(int i=0;i<N;i++){
            int[] mapx = Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<M;j++){
                map[i][j] = mapx[j];
            }
        }

        // 3.탐색 시작
        bfs(0,0);

        System.out.println(map[N-1][M-1]);

    }
}
