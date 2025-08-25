import java.util.*;
import java.io.*;


public class Main {
    static Deque<Integer> stack = new ArrayDeque<>(); // 스택
    static List<String> methodList = new LinkedList<>(); // 동작 출력을 위한 리스트
    static List<Integer> popList = new ArrayList<>(); //
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        int[] result = new int[tc];
        for(int i=0; i<tc;i++){
            // push연산은 +
            // pop 연산은 -
            // 불가능한 경우 NO
            result[i] = Integer.parseInt(bf.readLine());
        }

        int targetIndex = 0;
        for(int i=1;i<=tc;i++){
            // 숫자 값 push
            stack.addLast(i);
            methodList.add("+");

            // stack 맨 위에값이 result배열의 타겟값과 같을 경우
            while(targetIndex < tc && !stack.isEmpty() && Objects.equals(stack.peekLast(), result[targetIndex])){
                popList.add(stack.removeLast()); // pop
                methodList.add("-");
                targetIndex++; // 다음 타겟으로 진행
            }
        }

        // 마지막 targetIndex 검증
        while (targetIndex < tc && !stack.isEmpty() && Objects.equals(stack.peekLast(), result[targetIndex])) {
            popList.add(stack.removeLast());
            methodList.add("-");
            targetIndex++;
        }


        if (targetIndex == tc) {
            StringBuilder sb = new StringBuilder();
            for (String str : methodList) sb.append(str).append('\n');
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }

        

    }
}
