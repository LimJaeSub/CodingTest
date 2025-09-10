import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // () 한 쌍이여야 VPS임
        // VPS가 맞으면 yes 아니면 NO
        int tc = Integer.parseInt(bf.readLine());
        for(int i=0;i<tc;i++){
            String[] input = bf.readLine().split("");

            // VPS가 아닌 경우
            // 1. 배열을 다 돌았는데 양수임
            // 2. 한순간이라도 음수임
            int checknum = 0;
            for(int j=0;j<input.length;j++){
                if(Objects.equals(input[j],"(")){
                    checknum++;
                }
                else{
                    checknum--;
                }

                if(checknum<0 || (checknum>0 && j==input.length-1)){
                    System.out.println("NO");
                    break;
                }
            }
            if(checknum==0){
                System.out.println("YES");
            }

        }
    }
}