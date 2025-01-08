import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        int subject = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        double[] score = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max=score[0]; // 최댓값
        double sum = 0; // 평균을구하기위한 모든 점수 합

        // 1. 최댓값 찾기
        for(int i=1;i<score.length;i++){
            if(max<score[i]){
                max=score[i];
            }
        }
        // 2. 최댓값 이용하여 점수 조작 및 총합 구하기
        for(int i=0;i<score.length;i++){
            score[i] = (score[i]/max)*100;
            sum = sum+score[i];
        }

        double avg = sum/score.length;

        bw.write(avg+" ");
        bw.flush();
        bw.close();


        
        // 자바에서 계산값이 소수점이 나온다 싶으면 double형으로 바꿔주자 !






    }
}