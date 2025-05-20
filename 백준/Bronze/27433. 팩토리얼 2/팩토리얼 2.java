import java.util.*;
import java.io.*;


public class Main {
    static long fac(int n){
        if(n<=1){
            return 1;
        }
        return n * fac(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        System.out.println(fac(num));
    }
}