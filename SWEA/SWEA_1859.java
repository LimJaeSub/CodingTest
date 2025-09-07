import java.util.*;
import java.io.*;

public class SWEA_1859 {
    public static void main(String[] args) throws IOException {


        // 이 코드는 시간초과 났음 (앞에서 순회)
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        // 하루에 최대 1만큼 구입
//
//        int tc = Integer.parseInt(bf.readLine());
//
//        for(int i=0;i<tc;i++){
//            int day = Integer.parseInt(bf.readLine());
//            int[] price = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//            int[] sortprice = Arrays.stream(price).sorted().toArray();
//            List<Integer> sortpricelist = new ArrayList<>();
//            for(int k=0;k<sortprice.length;k++){
//                sortpricelist.add(sortprice[k]);
//            }
//
//            int max = sortpricelist.get(sortpricelist.size()-1);
//
//            StringBuilder sb = new StringBuilder();
//
//            long good = 0;
//            for(int j=0;j<day;j++){
//                int cur = price[j];
//                if(cur==max){
//                    // 현재 값이 남아있는 가장 비싼값일 경우
//                    // 가장 뒤에값 삭제
//                    // max값 갱신
//                    sortpricelist.remove(sortpricelist.size()-1);
//                    if(sortpricelist.size()>0){
//                        max = sortpricelist.get(sortpricelist.size()-1);
//                    }
//
//                }
//                else{
//                    // 현재 값이 비싼값보다 작을 경우
//                    good = good+(max-cur);
//
//                    //현재 값에 대한 인덱스 리스트에서 찾은 후 리스트에서 삭제
//                    int index = sortpricelist.indexOf(cur);
//                    sortpricelist.remove(index);
//                }
//            }
//            sb.append("#").append(i+1).append(" ").append(good);
//            System.out.println(sb);
//
//        }

        // 뒤에서 순회하는 방법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[] price = new int[N];
            int idx = 0;
            while (idx < N) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens() && idx < N) {
                    price[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            long profit = 0L;
            int maxSoFar = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (price[i] >= maxSoFar) maxSoFar = price[i];
                else profit += (maxSoFar - price[i]);
            }

            out.append("#").append(t).append(" ").append(profit).append("\n");
        }
        System.out.print(out.toString());

    }
}
