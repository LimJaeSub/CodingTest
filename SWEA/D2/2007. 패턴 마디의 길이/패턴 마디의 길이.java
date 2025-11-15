import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for(int i=0;i<tc;i++){
            String str = bf.readLine();
            char first = str.charAt(0);

            String[] strarr = str.split(String.valueOf(first));
            String firstindex = strarr[1];
            int count =1;
            int wordlength = firstindex.length();
            for(int j=2;j<strarr.length;j++){
                if(strarr[j].equals(firstindex)){
                    break;
                }
                else{
                    count++;
                    wordlength = wordlength+strarr[j].length();
                }
            }
            int result = count+wordlength;
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append(" ").append(result);
            System.out.println(sb);
        }
    }
}