import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(bf.readLine());
        int prevLastnum = 0; // 현재 수
        int cross_count = 1; // 기준 수

        while(true){
            if(input==1){
                bw.write("1/1");
                break;
            }
            if(prevLastnum + cross_count <input){
                prevLastnum = prevLastnum + cross_count; // 현재 수
                cross_count++; // 기준 수 증가
            }
            else if(prevLastnum + cross_count >=input){
                bw.flush();
                int k =(input- prevLastnum);
                int n =(prevLastnum + cross_count)-input+1;
                if(cross_count %2==1){
                    //기준 수가 홀수일 경우
                    bw.write(n+"/"+k);
                    bw.flush();
                    break;
                }
                else{
                    // 기준 수가 짝수일 경우
                    bw.write(k+"/"+n);
                    bw.flush();
                    break;
                }
            }
        }



        bw.close();

    }

}