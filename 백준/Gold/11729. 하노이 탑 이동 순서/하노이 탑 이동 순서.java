import java.util.*;
import java.io.*;


public class Main {
    static List<int[]> result = new ArrayList<>();
    static int count = 0;
    static void hanoi(int n,int from,int to,int via){
        count++;
        if(n==1){
            result.add(new int[]{from,to});
            return;
        }

        hanoi(n-1,from,via,to); // n번째 원반 위에 있는 것(n-1번째)부터 보조 탑으로 옮김
        result.add(new int[]{from,to}); // n번째 원반을 목적지에 옮김
        hanoi(n-1,via,to,from); // 보조 탑에 있는 n-1번째 원반을 목적지에 옮김

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int pan = Integer.parseInt(bf.readLine());
        hanoi(pan,1,3,2); // pan개의 팬을 1번 탑에서 3번탑으로 가는게 최종 목적임,2번은 서브탑
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for(int[] i : result){
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }

        System.out.println(sb);
    }
}