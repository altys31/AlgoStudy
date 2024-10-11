class Solution {
    public String solution(String s) {
        String answer = "";
        String lowerString = s.toLowerCase();
        boolean isEmpty = true;
        
        for(int i = 0; i< lowerString.length(); i++){
            if(lowerString.charAt(i) != ' '){
                if(isEmpty){
                    answer += lowerString.toUpperCase().charAt(i);
                    isEmpty = false;
                }
                else {
                    answer += lowerString.charAt(i);
                }
            }
            else {
                isEmpty = true;
                answer += lowerString.charAt(i); 
            }
            
            
        }

        return answer;
    }
}