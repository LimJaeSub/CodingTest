import java.io.*;
import java.util.*;


public class Main {
    static boolean[] visited;
    static LinkedList<ArrayList<Integer>> graph = new LinkedList<>();

    static void DFS(int i){
        visited[i]=true;

        // 그래프 간선 순회
        for(int a : graph.get(i)){
            if(!visited[a]){
                // 정점이 방문 안했으면 그 정점도 탐색
                DFS(a);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];

        // 0. 정점 갯수만큼 방문 배열 생성
        visited = new boolean[N+1];

        // 1. 정점 갯수만큼 그래프 초기화
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        // 2. 그래프에 간선 저장
        for(int i=0;i<M;i++){
            int[] line = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int no1 = line[0];
            int no2 = line[1];
            
            // * 양방향으로 간선 추가해줘야됨 !
            graph.get(no1).add(no2);
            graph.get(no2).add(no1);
        }


        // 3. dfs 돌기
        int count = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }

        System.out.println(count);

        }
    }
