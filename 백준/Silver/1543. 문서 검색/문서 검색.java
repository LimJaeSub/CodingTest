import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = bf.readLine();
        String word = bf.readLine();
        int count =0;
        for(int i=0;i<doc.length();i++){
            boolean isMatch = true;
            for(int j=0;j<word.length();j++){
                if(i+j>=doc.length() || doc.charAt(i+j)!=word.charAt(j)){
                    // 1.search하는 인덱스가 문서의 값보다 크면 인덱스를 넘어버림 => 찾을 필요 x
                    // 2. i 번째 인덱스부터 하나씩 점검
                    isMatch = false; // 한 글자라도 틀리면 찾는 단어가 아님
                    break; // 더이상 for문 돌릴 필요가 없음
                }
            }
            if(isMatch){ // isMatch==true
                count++; // 단어가 완전히 일치 시 갯수를 올림
                i = i+word.length()-1;
                // 이 코드에서 i는 시작점의 역할을 함
                // 단어 검색을 완료하였으니 다음 검색 지점은 시작점+단어의 갯수-1 (인덱스랑 길이랑 차이 확인)
            }
        }
        
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}