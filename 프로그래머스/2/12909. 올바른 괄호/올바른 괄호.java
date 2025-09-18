import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        String[] sarr = s.split("");

        int count = 0;
        boolean answer = true;
        for(int i=0;i<sarr.length;i++){
            if(Objects.equals("(",sarr[i])) {
                count = count +1;
            }
            else{
                count = count -1;
            }

            if(count<0){
                answer = false;
                break;
            }
        }
        
        if(Objects.equals(count,0)){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}