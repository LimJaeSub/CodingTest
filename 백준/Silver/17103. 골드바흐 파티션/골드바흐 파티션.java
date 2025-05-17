import java.util.*;
import java.io.*;


public class Main {

    static int MAX = 1000000;
    static List<Integer> PrimeList = new ArrayList<>();

    public static void makePrimeList(){

        // 에라토스테네스의 체
        boolean[] isNotPrime = new boolean[MAX + 1];
        isNotPrime[0] = isNotPrime[1] = true;


        // 소수에만 true 채움
        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) PrimeList.add(i);
        }
    }
    public static int partitionCount(int n) {


        // 투 포인터를 이용해 두 수 짝 구하기
        int count = 0;
        int left = 0;

        int right = 0;

        for(int i=0;i<PrimeList.size();i++){
            if(PrimeList.get(i)>n){
                right=i-1;
                break;
            }
        }


        // 1. 서로 다른 숫자로 이루어진 값
        while(left<right){
            int sum = PrimeList.get(left)+PrimeList.get(right);

            //정답값 찾았을 경우
            if(sum==n){
                // 카운팅 증기
                count++;
                // 다음 값 검색

                    left++;


                    right--;


            }
            // 합이 작으면 left 증가
            if(sum<n){

                    left++;


            }
            // 합이 크면 right 감소
            if(sum>n){

                    right--;


            }
        }

        // 2. 동일한 숫자로 이루어진 값
        for(int i=0;i<PrimeList.size();i++){
            if(PrimeList.get(i)*2==n){
                count++;
                break;
            }
        }
        return count;
    }





    public static void main(String[] args) throws IOException {
        makePrimeList();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<TC;i++){
            int input = Integer.parseInt(bf.readLine());
            int count = partitionCount(input);
            sb.append(count).append("\n");
        }
        System.out.println(sb);



    }
}