import java.io.*;
import java.util.*;


public class Main {
    static List<Integer> stack = new ArrayList<>();
    public static void cal1(int num){
        // push 함수
        stack.add(num);
    }
    public static void cal2(String order){
        switch(order){
            case "pop" :
                if(stack.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                }
                break;
            case "size" :
                System.out.println(stack.size());
                break;
            case "empty" :
                int a = stack.isEmpty() ? 1 : 0;
                System.out.println(a);
                break;
            case "top" :
                if(stack.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.get(stack.size()-1));
                }
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            String[] input = bf.readLine().split(" ");
            String order = input[0];
            if(Objects.equals(order, "push")){
               int num = Integer.parseInt(input[1]);
                cal1(num);
            }
            else{
                cal2(order);
            }

        }
    }
}