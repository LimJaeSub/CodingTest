import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int first = input[0];
            int second = 0;
            switch(first){
                case 1 :
                    second = input[1];
                    dq.addFirst(second);
                    break;
                case 2 :
                    second = input[1];
                    dq.addLast(second);
                    break;
                case 3 :
                    if(!dq.isEmpty()){
                        // 정수 있을경우 맨 앞 정수를 빼고 출력
                        System.out.println(dq.poll());
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
                case 4 :
                    if(!dq.isEmpty()){
                        // 정수 있을경우 맨 뒤 정수 빼고 출력
                        System.out.println(dq.pollLast());
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
                case 5 :
                    System.out.println(dq.size());
                    break;
                case 6 :
                    if(dq.isEmpty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;
                case 7 :
                    if(!dq.isEmpty()){
                        // 정수 있을경우 맨 앞 정수를 빼고 출력
                        System.out.println(dq.peek());
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
                case 8 :
                    if(!dq.isEmpty()){
                        // 정수 있을경우 맨 앞 정수를 빼고 출력
                        System.out.println(dq.peekLast());
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
