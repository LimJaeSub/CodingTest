import java.util.*;
import java.io.*;

public class SWEA_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            int tcnum = Integer.parseInt(bf.readLine());
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] countarr = new int[arr.length];

            int maxcount = 0; // 갯수
            int result = 0; // 값

            for(int j=0;j<arr.length;j++){
                countarr[arr[j]]++;
            }

            for(int k=0;k<countarr.length;k++){
                if(countarr[k]>=maxcount){
                    // 더 큰 갯수를 가진 수가 나오면?
                    maxcount=countarr[k];
                    result=k;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tcnum).append(" ").append(result);

            System.out.println(sb);
        }

    }
}
