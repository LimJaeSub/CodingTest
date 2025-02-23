import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word1 = bf.readLine();
        String word2 = bf.readLine();

        String[] parts1 = word1.split("");
        String[] parts2 = word2.split("");

        Arrays.sort(parts1);
        Arrays.sort(parts2);
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<parts1.length;i++){
            for(int j=0;j<parts2.length;j++){
                if(Objects.equals(parts1[i], parts2[j])){
                    parts1[i]="0";
                    parts2[j]="0";
                    count1++;
                    count2++;
                    break;
                }
            }
        }
        int result = parts1.length-count1 + parts2.length-count2;
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}