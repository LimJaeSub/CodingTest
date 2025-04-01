import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        String[] part = input.split("");

        Integer[] num = new Integer[part.length];

        for(int i=0;i<part.length;i++){
            num[i] = Integer.parseInt(part[i]);
        }

        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        
        String result = "";

        for(int i=0;i<num.length;i++){
            result = result + num[i].toString();
        }

        bw.write(result);
        bw.flush();
        bw.close();

    }
}