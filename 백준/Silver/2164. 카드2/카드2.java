import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        LinkedList<Integer> card = new LinkedList<>();

        for(int i=1;i<=tc;i++){
            card.add(i);
        }

        while(card.size()>1){

            // 맨위카드버리기
            card.remove(0);

            // 그다음 카드
            int next = card.get(0);
            // 그다음 카드 밑으로 보내기
            card.add(next);
            card.remove(0);
        }

        System.out.println(card.get(0));
    }
}
