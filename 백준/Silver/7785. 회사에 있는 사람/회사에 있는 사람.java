import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());

        // enter : 출근
        // leave : 퇴근
        // 출입 기록이 주어졌을 때 현재 회사에 남아 있는사람은?
        Set<String> company = new TreeSet<>(Comparator.reverseOrder());

        for(int i=0;i<tc;i++){
            String[] input = bf.readLine().split(" ");
            if(Objects.equals(input[1],"enter")){
                company.add(input[0]);
            }
            else{
                company.remove(input[0]);
            }
        }



        for(String man : company){
            bw.write(man+"\n");
        }
        bw.flush();
        bw.close();


    }
}