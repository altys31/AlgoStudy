import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int ticket = k;
        int maxRound = 0;
        int sum= 0;
          PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int i = 0; i<enemy.length; i++){
            pq.add(enemy[i]);
            sum += enemy[i];
            
            if(sum <= n){
                maxRound++;
                continue;
            }
            else{
                if(ticket > 0){
                    int Maxnumber = pq.poll();
                    sum -= Maxnumber;
                    ticket--;
                }
                else{
                    break;
                }
            }
            maxRound++;
        }

        return maxRound;
    }
}