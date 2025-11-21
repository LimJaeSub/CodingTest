import java.io.*;
import java.util.*;

class Solution {
    static int N, L;
    static int[] scores;
    static int[] calories;
    static int maxScore;
    
    public static void make(int index, int totalScore, int totalCal) {
        // 칼로리가 제한을 초과하면 종료
        if(totalCal > L) {
            return;
        }
        
        // 최대 점수 갱신
        maxScore = Math.max(maxScore, totalScore);
        
        // 모든 재료를 다 확인했으면 종료
        if(index == N) {
            return;
        }
        
        // 현재 재료를 선택하는 경우
        make(index + 1, totalScore + scores[index], totalCal + calories[index]);
        
        // 현재 재료를 선택하지 않는 경우
        make(index + 1, totalScore, totalCal);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(bf.readLine());
        
        for(int t = 1; t <= tc; t++) {
            int[] NL = Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
            N = NL[0];
            L = NL[1];
            
            scores = new int[N];
            calories = new int[N];
            maxScore = 0;
            
            // 재료 정보 입력
            for(int i = 0; i < N; i++) {
                int[] input = Arrays.stream(bf.readLine().split(" "))
                                .mapToInt(Integer::parseInt).toArray();
                scores[i] = input[0];
                calories[i] = input[1];
            }
            
            // 재귀 시작
            make(0, 0, 0);
            
            System.out.println("#" + t + " " + maxScore);
        }
    }
}