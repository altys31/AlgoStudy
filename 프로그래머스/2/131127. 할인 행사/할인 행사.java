import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        
        
        for(int i = 0; i<want.length; i++){
            map.put(want[i], number[i]);
            countMap.put(want[i], 0);
        }
        
        HashMap<String, Integer> copiedCountMap = new HashMap<>(countMap);

        Set<String> itemSet = map.keySet();
        
        int count = 0;
        int index = 0;
        
        while(true){
            
            if(!itemSet.contains(discount[index+count])){
                count = 0;
                copiedCountMap = new HashMap<>(countMap);
                index++;
                if(index+count >= discount.length)
                    break;
                continue;
            }
            else{
                copiedCountMap.put(discount[index+count], copiedCountMap.get(discount[index+count])+1);
                count++;
            }
            
            if(count == 10){
                if(map.equals(copiedCountMap)){
                    count = 0;
                    answer++;
                    index++;
                    copiedCountMap = new HashMap<>(countMap);
                }
                else{
                    count = 0;
                    copiedCountMap = new HashMap<>(countMap);
                    index++;
                }
            }
            
            if(index+count >= discount.length)
                break;
            
           
        }
        
        
        
        return answer;
    }
}