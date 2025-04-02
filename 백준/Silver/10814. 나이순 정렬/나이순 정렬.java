import java.io.*;
import java.util.*;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램

        int tc = Integer.parseInt(bf.readLine());

        String[][] arr = new String[tc][];

        for(int i=0;i<tc;i++){
            String[] part = bf.readLine().split(" ");
            arr[i] = part;
        }

        Arrays.sort(arr,new Comparator<String[]>(){
            @Override
            public int compare(String[] left,String[] right){
                int leftnum = Integer.parseInt(left[0]);
                int rightnum = Integer.parseInt(right[0]);
                return leftnum - rightnum;
            }
        });

        for(int i=0;i<tc;i++){
            bw.write(arr[i][0] +" "+ arr[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}