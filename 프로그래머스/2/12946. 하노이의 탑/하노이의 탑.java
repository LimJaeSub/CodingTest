import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2); // from:1 → to:3, via:2
        return result.toArray(new int[result.size()][]);
    }

    void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }

        hanoi(n - 1, from, via, to);       // 1단계: n-1개를 보조로
        result.add(new int[]{from, to});   // 2단계: 큰 원반 옮기기(배열로 나타남)
        hanoi(n - 1, via, to, from);       // 3단계: n-1개를 최종 목적지로
    }
}