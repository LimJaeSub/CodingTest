import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(bf.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            String input = bf.readLine();
            String[] part = input.split(" ");

            switch (part[0]) {
                case "push":
                    queue.addLast(Integer.parseInt(part[1]));  // O(1) 연산
                    break;
                case "pop":
                    bw.write(queue.isEmpty() ? "-1\n" : queue.pollFirst() + "\n");  // O(1) 연산
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(queue.isEmpty() ? "-1\n" : queue.peekFirst() + "\n");
                    break;
                case "back":
                    bw.write(queue.isEmpty() ? "-1\n" : queue.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}