import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(true){
            boolean checkAdd = false; 
            int maxValue = 0;
                
            for(int i = 0; i< arr.length; i++){
                maxValue = Math.max(arr[i], maxValue); 
            }
            
            for(int i = 2; i <= maxValue; i++){
                checkAdd = false; 
                for(int j = 0; j <arr.length; j++){
                    if(arr[j] % i == 0){
                        arr[j] /= i;
                        if(!checkAdd)
                            list.add(i);
                        checkAdd = true;
                    }
                }
                
                if(checkAdd)
                    break;
            }
            
            if(!checkAdd)
                break;
        }
        answer = 1; 
        
        for(int num : arr){
            answer *= num;
        }
        
        for(int num : list){
            answer *= num; 
        }
        
        return answer;
    }
}