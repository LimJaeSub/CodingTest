import java.io.*;
import java.util.*;


public class Main {

    // 삼각수 배열 만들기
    public static int[] threearr(int num){
        int[] arr = new int[num];
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum = sum + i;
            arr[i - 1] = sum;
        }
        return arr;
    }
    public static boolean three(int num, int[] threearr) {

        Set<Integer> set = new HashSet<>();
        for (int n : threearr) {
            set.add(n);
        }

        for (int i = 0; i < threearr.length; i++) {
            if (threearr[i] > num){
                break;
            }
            for (int j = 0; j < threearr.length; j++) {
                if (threearr[j] > num){
                    break;
                }
                int minus = num - (threearr[i] + threearr[j]);
                if (set.contains(minus)) {  // 올바르게 검사
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());
        for(int i=0;i<tc;i++){
            int num = Integer.parseInt(bf.readLine());
            int[] threearr = threearr(num);
            int result = three(num,threearr) ? 1 : 0;
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();



    }
}