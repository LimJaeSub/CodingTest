import java.util.*;
import java.io.*;


public class Main {
    static List<Integer> stack = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bf.readLine());

        for(int i=0;i<TC;i++){
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            switch(input[0]){
                case 1 :
                    stack.add(input[1]);
                    break;
                case 2 :
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        int out = stack.get(stack.size()-1);
                        stack.remove(stack.size()-1);
                        System.out.println(out);
                    }
                    break;
                case 3 :
                    System.out.println(stack.size());
                    break;
                case 4 :
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case 5 :
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(stack.get(stack.size()-1));
                    }
                    break;
            }

        }


    }
}