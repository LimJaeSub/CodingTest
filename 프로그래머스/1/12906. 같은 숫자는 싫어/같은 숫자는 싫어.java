import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        int target = arr[0];
        list.add(target);

        for(int i=1;i<arr.length;i++){
            // 연속 값이 아닐 경우
            // 타겟 숫자 바꿔주기
            // 값 넣어주기
            if(!Objects.equals(target,arr[i])){
                list.add(arr[i]);
                target = arr[i];
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}