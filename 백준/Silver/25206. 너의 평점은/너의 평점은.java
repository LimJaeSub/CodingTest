import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 등급이 P인 과목은 계산에서 제외
        // 과목명 학점 등급
        // (학점*등급) 의 합 / 학점 총합
        //ArrayList<Double> result = new ArrayList<>();
        double sum = 0;
        double k = 0;
        for(int i=0;i<20;i++){
            double score = 0.0;
            String[] input = bf.readLine().split(" ");
            double grade = Double.parseDouble(input[1]);
            switch(input[2]){
                case "A+" :
                    score=4.5;
                    break;
                case "A0" :
                    score=4.0;
                    break;
                case "B+" :
                    score=3.5;
                    break;
                case "B0" :
                    score=3.0;
                    break;
                case "C+" :
                    score=2.5;
                    break;
                case "C0" :
                    score=2.0;
                    break;
                case "D+" :
                    score=1.5;
                    break;
                case "D0" :
                    score=1.0;
                    break;
                case "F" :
                    score=0.0;
                    break;
                case "P" :
                    score=-1.0;
                default :
                    break;
            }

            if(score>=0){
                //bw.write("학점 : "+grade+"점수 : "+score+"\n");
                sum = sum+(score*grade);
                k=k+grade;
                //bw.write("학점의 합 : "+k+"\n");
                //bw.write("===================\n");
            }


        }


        double answer = sum/k;
        bw.write(answer+"");


        bw.flush();
        bw.close();




    }

}