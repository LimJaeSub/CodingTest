import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] farm;
    static int M, N;

    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void bfs(int x, int y) {
        // 정점의 좌표를 넣고 bfs 실행
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y}); // queue에 현재 좌표 넣음
        visited[x][y] = true; // 좌표 넣었으니 방문했음

        while (!queue.isEmpty()) { // 큐가 빌때까지 while문 반복
            int[] cur = queue.poll(); // queue의 최상위 요소 제거 후 추출
            int cx = cur[0]; // 추출한 최상위 요소의 x
            int cy = cur[1]; // 추출한 최상위 요소의 y

            for (int dir = 0; dir < 4; dir++) { // 상하좌우 4방향을 체크하기 위해 4번 반복함
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                // 각각 x,y축 이동


                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    // xy의 범위가 각각 0 ~ 농장의 끝까지
                    if (!visited[nx][ny] && farm[nx][ny] == 1) {
                        // 방문하지 않았으면서 배추가 있는곳이면?
                        queue.add(new int[]{nx, ny});
                        // 해당 좌표도 탐색을 하는거임
                        visited[nx][ny] = true;
                        // 방문했으니까 True
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N];
            farm = new int[M][N];

            // 배추 위치 저장
            for (int i = 0; i < target; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && farm[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
