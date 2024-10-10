import java.util.*;

class Solution {    
    static ArrayList<String> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static int length;
    static String cards;
    
    public int solution(String numbers) {
        int answer = 0;
        length = numbers.length();
        cards = numbers;
        
        boolean [] visited = new boolean[numbers.length()];
        
        String w = "";
        
        for(int i = 0; i <numbers.length(); i++){
            visited[i] = true;
            w += numbers.charAt(i);
            bt(visited, w);
            visited[i] = false;
            w = "";
        }
        
        for(int a: set){
            if(isPrime(a)){
                answer++;
            }
        }
        return answer;
    }
    
    public void bt(boolean[] visited, String w){
  
        set.add(Integer.parseInt(w));
        if(w.length() == length )
            return;
        
        for(int i = 0; i <length; i++){
            if(!visited[i]){
                String oldWord = w;
                visited[i] = true;
                w += cards.charAt(i);
                bt(visited, w);
                w = oldWord;
                visited[i] =false;
            }
        }
        
    }
    
    public boolean isPrime(int number){
        if (number == 1 || number == 0){
            return false;
        }
        for(int i = 2; i<number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}