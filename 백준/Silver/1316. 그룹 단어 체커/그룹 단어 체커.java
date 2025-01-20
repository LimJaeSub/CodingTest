import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(bf.readLine()); // 단어의 갯수
        String[] word = new String[input];
        int count=0;
        for(int i=0;i<input;i++){

            String k = bf.readLine();
            String[] n = k.split("");
            ArrayList<String> prev = new ArrayList<>(); // 나왔던 단어를 넣는 리스트
            String loop=n[0]; // 루프 단어
            boolean isCheck = true; // 지금 검사하는 단어가 그룹 단어가 맞는지?
            for(int j=0;j<n.length;j++){
                //bw.write("loop:" + loop+" n[j]:"+n[j]+"\n");
                if(!Objects.equals(loop, n[j])){
                    // 만약 현재 단어와 연속된 단어가 다를 경우 loop단어를 prev에 넣고 n[j]가 loop가 됨
                    prev.add(loop);
                    loop = n[j];
                }
                //loop에 넣은 단어가 prev list에 있으면 그룹 단어가 아님
                if(prev.contains(loop)){
                    // true 일경우 prev에 있단 소리니까  그룹 단어 아님! + break;
                    isCheck =false;
                    break;
                }
            }
            // 그룹단어가 맞으면 ?
            if(isCheck){
                count++;
            }


        }

        bw.write(count+"");




        bw.flush();
        bw.close();
    }
}