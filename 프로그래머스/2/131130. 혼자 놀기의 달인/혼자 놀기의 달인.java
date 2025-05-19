import java.util.ArrayList;
import java.lang.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i< cards.length; i++){
            if(cards[i] == 0)
                continue;
            int index = cards[i]-1;
            int score = 1;
            while(true){
               int newIndex = cards[index]-1; 
               cards[index] = 0;

               if(cards[newIndex] == 0){
                   break;
               }
               score++;
               index = newIndex;
            }
            list.add(score);
            if(score == cards.length){
                return 0;
            }
        }
        list.sort(null);
        answer = list.get(list.size()-1) * list.get(list.size()-2);
        return answer;
    }
}