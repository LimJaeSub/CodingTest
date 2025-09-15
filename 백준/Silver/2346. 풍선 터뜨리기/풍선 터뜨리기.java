import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 풍선 번호
        Deque<Integer> ballon = new ArrayDeque<>();
        // 티켓 값
        Deque<Integer> ticket = new ArrayDeque<>();

        int count = Integer.parseInt(bf.readLine());
        int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < count; i++){
            ballon.add(i + 1); // 1,2,3,4,5
            ticket.add(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        
        while(ballon.size() > 0) {
            // 1. 현재 풍선 터뜨리기
            int currentBallon = ballon.poll();
            int currentTicket = ticket.poll();
            
            sb.append(currentBallon).append(" ");
            
            // 2. 마지막 풍선이면 종료
            if(ballon.isEmpty()) break;
            
            // 3. 이동
            if(currentTicket > 0) {
                // 양수: 시계방향으로 currentTicket-1만큼 이동
                for(int i = 0; i < currentTicket - 1; i++){
                    ballon.addLast(ballon.pollFirst());
                    ticket.addLast(ticket.pollFirst());
                }
            } else {
                // 음수: 반시계방향으로 |currentTicket|만큼 이동
                for(int i = 0; i < Math.abs(currentTicket); i++){
                    ballon.addFirst(ballon.pollLast());
                    ticket.addFirst(ticket.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}