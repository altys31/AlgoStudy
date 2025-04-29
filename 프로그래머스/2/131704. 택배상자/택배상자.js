function solution(order) {
    var answer = 0;
    var spareBelt = [];
    for(let i = 1; i <= order.length; i++){
        
        var isOn = false;
        
        if(order[answer] === i){
            answer++;
            isOn = true;
        }
        
        while(spareBelt.length > 0 && spareBelt[spareBelt.length-1] === order[answer]){
            answer++;
            spareBelt.pop();
            isOn = true;
        }
        
        if(!isOn)
            spareBelt.push(i);
    }
    
    return answer;
}