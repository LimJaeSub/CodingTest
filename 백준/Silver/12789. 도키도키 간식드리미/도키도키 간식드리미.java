import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int student = Integer.parseInt(bf.readLine());
        int[] num = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> stacklist = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<student;i++){
            pq.offer(num[i]);
        }

        for(int i=0;i<student;i++){
            // 현재 최고 우선순위
            int check = pq.peek();
            if(num[i]==check){
                // 현재 값이 최고 우선순위면 바로 간식 받기
                pq.poll(); // 맨 앞에값 삭제
                // 우선순위가 변경되었으니 스택 다시한번 확인

                // 우선순위를 일단 스택에서 확인
                // 스택의 맨 위가 현재 우선순위 일경우?
                while(true){
                    // 우선순위 큐가 비어있지 않으면 우선순위 탐색
                    // 비어있는경우라면 이미 다 간식 먹은상태임
                    if(!pq.isEmpty()){
                        check=pq.peek();
                    }
                    else{
                        break;
                    }

                    // 스택이 비어있지 않고, 스택 맨 위값이 현재 우선순위 값과 같으면 도출
                    if(!stacklist.isEmpty() && stacklist.get(stacklist.size()-1)==check){
                        pq.poll();
                        stacklist.remove(stacklist.size()-1);
                    }
                    else{
                        break;
                    }
                }

            }
            else{
                // 현재 값이 최고 우선순위가 아닐 경우?
                // 스택 리스트에 넣어둔다.
                stacklist.add(num[i]);


            }
        }

        // 위 for문 돌면 우선순위 큐하고 스택하고 남음
        // 우선순위 큐를 순회해서 스택 값 빼주기
        int size = pq.size();
        if(!stacklist.isEmpty()){
            for(int i=0;i<size;i++){
                if(Objects.equals(pq.peek(),stacklist.get(stacklist.size()-1))){
                    pq.poll();
                    stacklist.remove(stacklist.size()-1);
                }
            }
        }


        // 스택이 완전히 비어있다면? 먹을수있음
        // 있으면? 못먹음
        System.out.println(stacklist.isEmpty() ? "Nice" : "Sad");
    }
}