import java.util.*;
import java.io.*;


public class Main {
    static int count = 0;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        count =0;
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(bf.readLine());

        for(int i=0;i<TC;i++){
            String str = bf.readLine();
            int result = isPalindrome(str);
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append(result).append(" ").append(count));
        }
    }
}