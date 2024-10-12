class Solution {
    static int answer;
    static int targetNum;
    public int solution(int[] numbers, int target) {
        
        answer = 0;
        targetNum = target;
        
        backtracking(0, numbers);
        
        return answer;
    }
    
    public void backtracking(int level, int[] numbers){
        if(level == numbers.length){
            int sum = 0;
            for(int num : numbers){
                sum += num;
            }
            if(sum == targetNum)
                answer++;
            return;
        }
        
        for(int i = 0; i <2; i++){
            if(i ==0){
                numbers[level] *= -1;
                backtracking(level+1, numbers);
                numbers[level] *= -1;
            }
            else
                backtracking(level+1, numbers);
        }
        
    }
}