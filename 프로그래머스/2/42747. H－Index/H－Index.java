import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i = 0 ; i< citations.length; i++){
            if(answer < citations[citations.length -1 -i] && answer <= i){
                answer = i+1;
            } 
        }
        
        return answer;
    }
}