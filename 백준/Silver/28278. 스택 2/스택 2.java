import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(bf.readLine());

        for (int i = 0; i < TC; i++) {
            String[] parts = bf.readLine().split(" ");
            int cmd = Integer.parseInt(parts[0]);

            switch (cmd) {
                case 1:
                    stack.add(Integer.parseInt(parts[1]));
                    break;
                case 2:
                    sb.append(stack.isEmpty() ? -1 : stack.remove(stack.size() - 1)).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 5:
                    sb.append(stack.isEmpty() ? -1 : stack.get(stack.size() - 1)).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
