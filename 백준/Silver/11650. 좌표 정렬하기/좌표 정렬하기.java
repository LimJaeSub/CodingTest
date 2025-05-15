import java.util.*;
import java.io.*;


// 11650
public class Main {

    static class XY{
        int num_x;
        int num_y;

        XY(int x,int y){
            this.num_x = x;
            this.num_y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Set<XY> spot = new LinkedHashSet<>();

        for(int i=0;i<N;i++){
            int[] num = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            spot.add(new XY(num[0],num[1]));
        }

        List<XY> spotlist = new ArrayList<>(spot);

        spotlist.sort((a,b)->{
            if(a.num_x==b.num_x){
                return a.num_y-b.num_y;
            }
            return a.num_x-b.num_x;
        });

        StringBuilder sb = new StringBuilder();

        for(XY xy : spotlist){
            sb.append(xy.num_x).append(" ").append(xy.num_y).append("\n");
        }

        System.out.print(sb);



    }
}