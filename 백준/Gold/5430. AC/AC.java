import java.util.*;
import java.io.*;

public class Main {
    public static void AC(String[] func, int arrlen, String arr) {
        // 1) 배열 파싱
        List<Integer> result = new ArrayList<>(arrlen);
        String body = arr.substring(1, arr.length() - 1); // "1,2,3" 또는 ""
        if (!body.isEmpty()) {
            // 성능상 split/stream은 무거울 수 있지만, 네 스타일 유지
            String[] parts = body.split(",");
            for (int i = 0; i < parts.length; i++) {
                result.add(Integer.parseInt(parts[i]));
            }
        }

        // 2) 명령 처리: rev 플래그 + 양끝 포인터만 이동 (실제 삭제 X)
        boolean rev = false;
        int left = 0;
        int right = result.size() - 1;

        for (int i = 0; i < func.length; i++) {
            String op = func[i];
            if (op.equals("R")) {
                rev = !rev;
            } else { // "D"
                if (left > right) { // 현재 남은 구간이 비었음
                    System.out.println("error");
                    return; // 즉시 종료
                }
                if (!rev) {
                    left++;      // 앞에서 하나 버림
                } else {
                    right--;     // 뒤에서 하나 버림
                }
            }
        }

        // 3) 출력 (공백 없이, rev에 따라 방향만 달리)
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (left <= right) {
            if (!rev) {
                for (int i = left; i <= right; i++) {
                    if (i > left) sb.append(',');
                    sb.append(result.get(i));
                }
            } else {
                for (int i = right; i >= left; i--) {
                    if (i < right) sb.append(',');
                    sb.append(result.get(i));
                }
            }
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for (int t = 0; t < tc; t++) {
            String[] func = bf.readLine().split("");  
            int arrlen = Integer.parseInt(bf.readLine());
            String arr = bf.readLine();               
            AC(func, arrlen, arr);
        }
    }
}
