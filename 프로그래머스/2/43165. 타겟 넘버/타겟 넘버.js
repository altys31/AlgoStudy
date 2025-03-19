var answer = 0;

function solution(numbers, target) {
    bt(numbers, target,0,0);
    return answer;
}

const bt = (numbers, target,sum, level) => {
    if(level === numbers.length){
        if(target === sum)
            answer++;
        return;
    }
    
    bt(numbers, target, sum+numbers[level], level+1);
    bt(numbers, target, sum-numbers[level], level+1);
    
}