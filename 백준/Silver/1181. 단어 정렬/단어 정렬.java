import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        길이가 짧은 것부터
//        길이가 같으면 사전 순으로
//        단, 중복된 단어는 하나만 남기고 제거해야 한다.

        int tc = Integer.parseInt(bf.readLine());
        String[] arr = new String[tc]; // 글자를 넣을 배열

        for(int i=0;i<tc;i++){
            arr[i] = bf.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                // 음수 : left가 왼쪽
                // 양수 : right가 왼쪽
                if(left.length()==right.length()){
                    return left.compareTo(right);
                }
                return left.length()-right.length();
            }
        });

        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1 && Objects.equals(arr[i], arr[i + 1])){
                continue;
            }
            bw.write(arr[i]+"\n");
        }

        bw.flush();
        bw.close();
    }
}