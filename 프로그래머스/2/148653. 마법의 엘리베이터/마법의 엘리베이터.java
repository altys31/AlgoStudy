class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int current = storey % 10; 
            storey /= 10;  
            
            if (current > 5 || (current == 5 && (storey % 10) >= 5)) {

                answer += 10 - current;  
                storey++;  
            } else {
                answer += current;
            }
        }
        
        return answer;
    }
}
