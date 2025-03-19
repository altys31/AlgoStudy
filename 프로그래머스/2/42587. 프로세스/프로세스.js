function solution(priorities, location) {
    var answer = 0;
    let currentLocation = location;
    let currentPriority = Math.max(...priorities);
    
    while(true){
        const currentProcess = priorities.shift();
        currentLocation --;

        if(currentProcess != currentPriority){
            priorities.push(currentProcess);
            if(currentLocation === -1)
                currentLocation = priorities.length-1;
        }
        else{
            answer++;
            if(currentLocation === -1)
                return answer;
        }
        
        // 리스트 내 가장 높은 우선순위 재탐색
        currentPriority = Math.max(...priorities);
    }
    
}
