import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = bf.readLine();
            if(input.equals(".")){
                break;
            }
            input = input.replaceAll("[^()\\[\\]]","");
            String[] str = input.split("");


            // str을 loop
            // (,[ 일경우 stacklist에 집어넣음
            // ),] 이 들어올 경우 스택의 top을 확인
            // top이랑 반대쌍이면 out시킴
            // top이랑 반대쌍이 아닐 경우? > 균형아님
            // 스택에 값이 남아있을 경우? > 균형아님
            // 스택에 아무것도 없는데 ),]이 들어올 경우? > 균형아님
            // 최종적으로 스택에 아무 값이 없으면? > 균형

            StringBuilder sb = new StringBuilder();
            List<String> stacklist = new LinkedList<>();
            for(int i=0;i<str.length;i++){
                if(Objects.equals(str[i],"(") || Objects.equals(str[i],"[")){
                    stacklist.add(str[i]);
                }
                else if(Objects.equals(str[i],")")){
                    if(stacklist.isEmpty()){
                        sb.append("no");
                        break;
                    }
                    String top = stacklist.get(stacklist.size()-1);
                    if(Objects.equals(top,"(")){
                        // 반대쌍 일경우
                        stacklist.remove(stacklist.size()-1);
                        // 가장 위에값 제거
                    }
                    else{
                        // 반대쌍이 아닌데 닫는게 들어왔다? > 균형아님,for문돌필요x
                        sb.append("no");
                        break;
                    }
                }
                else if(Objects.equals(str[i],"]")){
                    if(stacklist.isEmpty()){
                        sb.append("no");
                        break;
                    }
                    String top = stacklist.get(stacklist.size()-1);
                    if(Objects.equals(top,"[")){
                        // 반대쌍 일경우
                        stacklist.remove(stacklist.size()-1);
                        // 가장 위에값 제거
                    }
                    else{
                        // 반대쌍이 아닌데 닫는게 들어왔다? > 균형아님,for문돌필요x
                        sb.append("no");
                        break;
                    }
                }
            }
            // 최종적으로 스택 확인
            if(sb.isEmpty()){
                if(stacklist.isEmpty()){
                    sb.append("yes");
                }
                else{
                    sb.append("no");
                }
            }
            System.out.println(sb);


        }
    }
}