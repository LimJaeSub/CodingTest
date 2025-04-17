import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int n = sc.nextInt();
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }

        // 2. 복사해서 정렬하기
        int[] sorted = original.clone();
        Arrays.sort(sorted);

        // 3. Map을 이용해서 좌표 압축 값 저장
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        // 4. 원래 배열을 순회하며 압축 값 출력
        StringBuilder sb = new StringBuilder();
        for (int num : original) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}