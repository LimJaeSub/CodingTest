import java.util.*;

public class Main {
    public static void cantor(char[] arr, int start, int length) {
        if (length < 3) return;

        int part = length / 3;

        // 가운데 부분 공백으로 바꿈
        for (int i = start + part; i < start + 2 * part; i++) {
            arr[i] = ' ';
        }

        // 왼쪽, 오른쪽 재귀
        cantor(arr, start, part);
        cantor(arr, start + 2 * part, part);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int len = (int) Math.pow(3, n);

            char[] arr = new char[len];
            Arrays.fill(arr, '-');

            cantor(arr, 0, len);

            System.out.println(arr);
        }

        sc.close();
    }
}
