import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int i=0;i<tc;i++){
            int isOk = 1;  // 기본값을 1로 시작

            int[][] stoku = new int[9][9];
            Set<Integer> num = new HashSet<>();

            // 입력값 넣으면서 가로줄 검사
            for(int col = 0; col < 9; col++){
                int[] line = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                stoku[col] = line;  // 일단 모두 저장
                
                num.clear();  // 매 행마다 초기화
                for(int k=0;k<9;k++){
                    num.add(line[k]);
                }
                if(num.size() != 9){
                    isOk = 0;  // 실패 표시
                }
            }

            // 세로줄 검사 (isOk가 1일 때만)
            if(isOk == 1){
                for(int row=0;row<9;row++){
                    num.clear();  // 매 열마다 초기화
                    for(int col=0;col<9;col++){
                        num.add(stoku[col][row]);
                    }
                    if(num.size()!=9){
                        isOk = 0;
                        break;
                    }
                }
            }

            // 칸 검사 (isOk가 1일 때만)
            if(isOk == 1){
                boolean failed = false;
                for(int square_col = 0; square_col < 9; square_col += 3){
                    for(int square_row = 0; square_row < 9; square_row += 3){
                        num.clear();  // 매 3x3 박스마다 초기화
                        
                        for(int a = 0; a < 3; a++){
                            for(int b = 0; b < 3; b++){
                                num.add(stoku[square_col + a][square_row + b]);
                            }
                        }
                        
                        if(num.size() != 9){
                            isOk = 0;
                            failed = true;
                            break;
                        }
                    }
                    if(failed) break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append(" ").append(isOk);
            System.out.println(sb);
        }
    }
}