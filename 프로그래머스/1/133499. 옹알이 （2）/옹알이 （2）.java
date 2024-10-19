import java.util.*;

class Solution {
    static String[] words = {"aya","ye","woo","ma"};
    static int answer;
    public int solution(String[] babbling) {
        answer = 0;
        
        for(String word : babbling){
            bt(word, "");
        }
        
        return answer;
    }
    
    static void bt(String word, String prev){
        
        for(String part: words){
            if(word.length() < part.length() || part.equals(prev))
                    continue;
                
            if(word.substring(0,part.length()).equals(part)){
                
                String newWord = word.substring(part.length(),word.length());
                
                if(newWord.length() > 0){
                    bt(newWord,part);
                }
                
                else if(newWord.length() == 0 ){
                    answer++;
                }
            }
        }
        
    }
        
}