import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        // 문자열에 찾고자 하는 문자열이 포함되어있는지 확인하는 contain() 사용
        String[] croa = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i=0;i<croa.length;i++){
            if(input.contains(croa[i])){
                // 크로아티아 변형 문자를 전부 ? 로 바꿈
                // input 조건 "첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다."
                input = input.replace(croa[i],"?");
            }
        }

        bw.write(input.length()+"");
        bw.flush();
        bw.close();
    }
}