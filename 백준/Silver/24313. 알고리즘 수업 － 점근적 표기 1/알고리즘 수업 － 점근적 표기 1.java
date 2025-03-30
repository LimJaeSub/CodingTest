import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = bf.readLine().split(" ");
        int fn1 = Integer.parseInt(input[0]);
        int fn2 = Integer.parseInt(input[1]);

        int c = Integer.parseInt(bf.readLine());
        int n0 = Integer.parseInt(bf.readLine());

        //수식 f(n) ≤ c × g(n)
        int num1 = fn1*n0+fn2;
        int num2 = c*n0;

        int m = fn1*n0+fn2<=c*n0 && (c>fn1 || (c==fn1 && fn2<=0))  ? 1 : 0;

        bw.write(m+"");
        bw.flush();
        bw.close();




    }
}