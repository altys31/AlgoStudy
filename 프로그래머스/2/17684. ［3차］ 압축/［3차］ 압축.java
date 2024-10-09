import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> output = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i<=26; i++){
            map.put(String.valueOf((char)(64+i)),i);
        }
        
        int nowIdx = 27;
        int length = msg.length();
        int idx = 0;
        
        while(idx < length){
            
            String w = "";
            int j = idx;
            
            while( j < length && map.containsKey(w+msg.charAt(j))){
                w += msg.charAt(j);
                j++;
            }
            
            output.add(map.get(w));
            
            if (j < length) {
                map.put(w+msg.charAt(j), nowIdx++);
            }
            
            idx += w.length();
            
        }
        
       int[] answer = new int[output.size()];
        for(int i = 0; i < output.size(); i++){
            answer[i] = output.get(i);
        }
        
        return answer;
    }
}