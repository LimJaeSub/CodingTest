import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static LinkedList<ArrayList<Integer>> graph = new LinkedList<>(); // 간선을 저장하는 리스트
    static boolean[] visited;

    static void DFS(int v){
        visited[v] = true; // v 정점에 방문했음
        System.out.print(v+" "); // 방문했으니까 출력

        // v 정점에 연결된 간선 순회
        for(int i : graph.get(v)){
            if(!visited[i]){
                // 방문 안 했으면 방문 시켜야함
                // 전부 true(전부 방문)일경우 그대로 for문 종료
                DFS(i);
                // v와 연결된 정점과 연결된 방문하지 않은 노드가 발견될경우 바로 재귀함수 실행
                // 계속 하위 노드로 내려감
            }
        }
    }

    static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v); // 방문하고 나서 출력 준비를 하는 queue에 저장

        // queue에 있는 간선을 탐색하는 while문
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+" "); // 방문완료했으니까 출력

            for(int i : graph.get(node)){ // 해당 정점의 간선 탐색
                if(!visited[i]){
                    visited[i] =true;
                    queue.offer(i); // 방문 안 한 정점만 queue에 넣고 다시 간선 탐색
                    // queue에 들어간 순서대로 간선을 모두 탐색함
                    // 간선 탐색 도중 하위 정점이 있으면 queue의 맨 뒤에 들어가서 넓이 우선 탐색이 됨
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0]; // 정점 갯수
        int m = input[1]; // 간선 갯수
        int v = input[2]; // 시작할 정점의 번호

        // 정점 갯수만큼 그래프 초기화
        // 각 정점마다 ArrayList 생성
        // 밑에 ArrayList에 간선 정보 입력
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        // 간선을 받아서 저장하는 for문
        for(int i=0;i<m;i++){
            int[] move = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = move[0];
            int a = move[1];
            graph.get(a).add(s);
            graph.get(s).add(a);
        }

        // 정점이 여러개일 경우 정점 정렬
        for(ArrayList<Integer> i : graph){
            Collections.sort(i);
        }


        // DFS 수행 결과
        visited = new boolean[n+1];
        DFS(v);
        
        System.out.print("\n");

        // BFS 수행 결과
        visited = new boolean[n+1];
        BFS(v);




    }

}
