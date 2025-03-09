import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = bf.readLine();
        String b = bf.readLine();
        int time = Integer.parseInt(bf.readLine());

        String[] map = a.split(" ");
        String[] start = b.split(" ");

        int x_max = Integer.parseInt(map[0]);
        int y_max = Integer.parseInt(map[1]);

        int x_start = Integer.parseInt(start[0]);
        int y_start = Integer.parseInt(start[1]);


        int result_x =0;
        int result_y =0;

        
        if(x_start+time>x_max){

                int roadx = time-(x_max-x_start);
                if((roadx/x_max)%2==0){
                    // 짝수일경우 음수방향으로 이동
                    result_x=x_max-(roadx%x_max);
                }
                else if((roadx/x_max%2)!=0){
                    // 홀수일 경우 양수 방향으로 이동
                    result_x=roadx%x_max;
                }
        }
        else{
            result_x=x_start+time;
        }


        if(y_start+time>y_max){
            int roady = time-(y_max-y_start);
            if((roady/y_max)%2==0){
                // 짝수일경우 음수방향으로 이동
                result_y=y_max-(roady%y_max);
            }
            else if((roady/y_max%2)!=0){
                // 홀수일 경우 양수 방향으로 이동
                result_y=roady%y_max;
            }
        }

        else{
            result_y = y_start+time;
        }
        
        bw.write(result_x+" "+result_y);
        bw.flush();
        bw.close();
    }
}
