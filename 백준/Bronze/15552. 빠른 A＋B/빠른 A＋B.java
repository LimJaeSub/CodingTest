import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




        int tc = Integer.parseInt(br.readLine()); // tc갯수
        for(int i=0;i<tc;i++){
            String input = br.readLine(); // 입력값
            String[] parts = input.split(" ");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);
            bw.write(num1+num2+"\n");
        }

        bw.flush();
        bw.close();



    }
}