import java.util.*;
import java.io.*;


// 11650
public class Main {

    static class XY{
        int num_x;
        int num_y;

        XY(int a,int b){
            this.num_x = a;
            this.num_y = b;
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(bf.readLine());


       // Set 에다가 XY 좌표 넣어줌
       Set<XY> spot = new LinkedHashSet<>();
       for(int i=0;i<N;i++){
           int[] inputnum = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           spot.add(new XY(inputnum[0],inputnum[1]));
       }

       // XY Class 구성된 LinkedList 생성, spot set 구성됨.
       List<XY> spotlist = new LinkedList<>(spot);


       // LinkedList 정렬
       spotlist.sort((a,b)->{
           if(a.num_y==b.num_y){
               return a.num_x - b.num_x;
           }
           return a.num_y - b.num_y;
       });


        // 향상된 for문+StringBuilder를 이용해 출력
        StringBuilder sb = new StringBuilder();
        for(XY xy : spotlist){
            // XY 형인 인자 xy로 구성된 spotlist를 순회
            sb.append(xy.num_x).append(" ").append(xy.num_y).append("\n");
        }

        System.out.println(sb);




    }
}