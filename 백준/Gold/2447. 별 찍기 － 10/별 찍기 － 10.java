import java.util.*;

public class Main {
    static char[][] field;

    // 재귀 함수: 현재 범위는 [startRow ~ endRow), [startCol ~ endCol)
    public static void star(int startRow, int endRow, int startCol, int endCol) {
        int size = endRow - startRow;

        if (size == 1) return;

        int div = size / 3;

        // 가운데 영역을 공백 처리
        for (int i = startRow + div; i < startRow + 2 * div; i++) {
            for (int j = startCol + div; j < startCol + 2 * div; j++) {
                field[i][j] = ' ';
            }
        }

        // 3x3 구간 중 8개만 재귀 호출
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                if (dx == 1 && dy == 1) continue; // 가운데는 공백만 처리하고 재귀 안함

                int newStartRow = startRow + dx * div; // 시작지점 + 구간 * 분할단위
                int newEndRow = newStartRow + div;

                int newStartCol = startCol + dy * div;
                int newEndCol = newStartCol + div;

                star(newStartRow, newEndRow, newStartCol, newEndCol);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt(); // 입력 크기

        field = new char[input][input];

        // 전체를 *로 초기화
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                field[i][j] = '*';
            }
        }

        // 전체 영역에 대해 재귀 호출
        star(0, input, 0, input);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append(field[i]);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
