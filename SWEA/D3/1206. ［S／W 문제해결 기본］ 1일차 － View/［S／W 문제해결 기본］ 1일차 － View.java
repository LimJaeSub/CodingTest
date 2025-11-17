import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = 10;
        List<Integer> floorlist = new ArrayList<>();
        for(int i=0;i<tc;i++){
            int count = 0;
            int build = Integer.parseInt(bf.readLine());
            int[] floor = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int j=2;j<build-2;j++){
                floorlist.add(floor[j-2]);
                floorlist.add(floor[j-1]);
                floorlist.add(floor[j]);
                floorlist.add(floor[j+1]);
                floorlist.add(floor[j+2]);
                Collections.sort(floorlist,Collections.reverseOrder());
                // floorlist에서 첫번째 값이 floor[j] 일경우
                // 첫번째 값에서 두번째 값을 뺀게 조망값임
                if(floorlist.get(0)==floor[j]){
                    count = count+(floorlist.get(0)-floorlist.get(1));
                }
                floorlist.clear();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append(" ").append(count);
            System.out.println(sb);
        }
    }
}