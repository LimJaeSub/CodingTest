
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(bf.readLine());
        
        for(int i=0;i<tc;i++) {
        	int[] original =Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        	int length = original.length;
        	int[] change = new int[length];
        	
        	int count = 0;
        	boolean isSame = false;
        	while(isSame==false) {
        		for(int j=0;j<length;j++) {
        			if(original[j]!=change[j]) {
        				// 다른 비트 발생시 메모리 끝까지 덮어씌우기
        				count++;
        				if(change[j]==0) {
        					// 1로 덮어씌우기
        					for(int k=j;k<length;k++) {
        						change[k]=1;
        					}
        				}
        				else {
        					for(int k=j;k<length;k++) {
        						change[k]=0;
        					}
        				}
        				break;
        			}
        		}
        		
        		for(int m=0;m<length;m++) {
        			if(original[m]!=change[m]) {
        				// 비트가 다른게 하나라도 감지될 경우 break;
        				isSame=false;
        				break;
        			}
        			else {
        				isSame=true;
        			}
        		}
        		
        	}
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i+1).append(" ").append(count);
        	System.out.println(sb);
        }
    }
}