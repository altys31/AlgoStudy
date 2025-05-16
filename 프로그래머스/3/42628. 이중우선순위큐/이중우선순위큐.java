import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        //ArrayList<Integer> answer = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b-a);

        for(String operation : operations){
            String[] op =  operation.split(" ");
            int num = Integer.parseInt(op[1]);
            
            if(op[0].equals("I")){
                pq.add(num);
            }
            if(op[0].equals("D") && num == 1 && pq.size() > 0){
                pq.poll();
            }
            if(op[0].equals("D") && num == -1 && pq.size() > 0){
                int [] buffer = new int[pq.size()];
                int size = pq.size();
                
                for(int i = 0; i<size; i++)
                    buffer[i] = pq.poll();
                for(int i =0; i<size-1; i++){
                    pq.add(buffer[i]);
                }
            }
        }
        
        int max = pq.size() > 0 ? pq.peek() : 0;
        int min = 0;
        int size= pq.size();
        
        for(int i =0; i<size; i++){
            
            if(i != size-1)
                pq.poll();
            else
                min = pq.poll();
        
        }
        
        
        answer = new int[] {max,min};
        
        return answer;
    }
}