import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            int[] first = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] list = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int doccount = first[0];   // 문서 개수
            int location = first[1];   // 찾을 문서 위치

            
            Deque<Integer> doclist = new ArrayDeque<>();
            Deque<Integer> mark    = new ArrayDeque<>(); // 해당 문서 표시(1) / 아니면 0

            for (int j = 0; j < doccount; j++) {
                doclist.addLast(list[j]);
                mark.addLast(j == location ? 1 : 0);
            }

            int printcount = 0;

            while (!doclist.isEmpty()) {
                int frontPriority = doclist.peekFirst();
                int frontMark = mark.peekFirst();

                // 현재 맨 앞보다 더 높은 우선순위가 큐에 있는지 확인
                boolean hasHigher = false;
                for (int p : doclist) {
                    if (p > frontPriority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    // 맨 앞을 맨 뒤로 보내기
                    // 맨 앞 요소를 삭제 시 뒤에 요소 다 땡겨져서 옴
                    doclist.removeFirst();
                    doclist.addLast(frontPriority);
                    mark.removeFirst();
                    mark.addLast(frontMark);
                } else {
                    // 출력
                    doclist.removeFirst();
                    mark.removeFirst();
                    printcount++;

                    if (frontMark == 1) {
                        sb.append(printcount).append('\n');
                        break; // 이 테스트케이스 끝
                    }
                }
            }
        }

        System.out.print(sb.toString());
    }
}
