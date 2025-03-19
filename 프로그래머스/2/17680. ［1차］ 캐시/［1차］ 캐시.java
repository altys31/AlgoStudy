import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        
        for(String city : cities){
            String lowerCity = city.toLowerCase();
            if(list.contains(lowerCity)){
                list.remove(lowerCity);
                answer += 1;
                list.add(lowerCity);
            }
            else{
                answer += 5;
                if(cacheSize != 0){
                    if( list.size() == cacheSize)
                        list.remove(0);
                    list.add(lowerCity);
                }
            }
            
        }
        
        return answer;
    }
}