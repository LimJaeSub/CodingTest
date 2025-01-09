import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        String s = bf.readLine();
        String[] parts = s.split("");
        int[] asciiarr = new int[parts.length]; // 입력받은 문자열 전부 아스키코드로 변환
        for(int i=0;i<parts.length;i++){
            asciiarr[i] = parts[i].charAt(0);
        }

        int[] alphabet = IntStream.rangeClosed(97,123).toArray(); // 알파벳 아스키코드 배열
        int[] result = new int[26]; // 정답입력배열
        Arrays.fill(result,-1);

        for(int i=0;i<alphabet.length;i++){
            for(int j=0;j<asciiarr.length;j++){
                if(asciiarr[j]==alphabet[i]){
                    result[i]=j;
                    break;
                }
            }
        }
        String answer = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bw.write(answer);
        bw.flush();
        bw.close();


    }
}