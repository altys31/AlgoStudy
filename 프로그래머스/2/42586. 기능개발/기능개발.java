import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
 
        int count = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(true){
            int doneProgresses = 0;
            
            for(int i = 0; i< progresses.length; i++){
                if(progresses[i] != 0){
                    progresses[i] += speeds[i];
                }
            }
            
            for(int i =0; i<progresses.length; i++){
                if(progresses[i] == 0)
                    continue;
                if(progresses[i] >= 100){
                    count++;
                    doneProgresses++;
                    progresses[i] = 0;
                }
                else
                    break;
            }
            
            if(doneProgresses != 0)
                list.add(doneProgresses);
            
            if(count == progresses.length)
                break;
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}