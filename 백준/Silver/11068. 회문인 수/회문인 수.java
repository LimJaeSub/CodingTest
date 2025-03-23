import java.io.*;


public class Main {
    public static int[] convertBase(int x,int base){
        int length = 0;

        // 진법 변환이 완료되었을 때 자릿수
        int tmp = x;
        while(tmp>0){
            tmp=tmp/base;
            length++;
        }

        int[] digit = new int[length];
        length=0;
        while(x>0){
            digit[length] = x%base;
            x = x/base;
            length++;
        }
        return digit;

    }

    // 회문 수 판별
    public static boolean isPalindrome(int[] digit){
        for(int i=0;i<digit.length/2;i++){
            // 서로 대칭되는 수만 검사하면 되므로 배열의 절반만 돌림
            if(digit[i]!=digit[digit.length-i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(bf.readLine());


        for(int i=0;i<tc;i++){
            int n = Integer.parseInt(bf.readLine());
            boolean answer = false;

            // 진법 변환
            for(int j = 2; j <=64; j++){
                int[] digit = convertBase(n, j); // convertBase 함수에서 변환 해줌

                // 변환 체크 if문
                if(isPalindrome(digit)){
                    answer = true;
                    break;
                }
            }
            String result = answer ? "1" : "0" ;
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();


    }
}