import java.util.*;
import java.io.*;


public class Main {
    static int fib(int a){
        // 종료 조건
        if(a==0){
            return 0;
        }
        if(a==1){
            return 1;
        }
        return fib(a-1)+fib(a-2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        System.out.println(fib(a));
    }
}