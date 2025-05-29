function solution(numbers) {
    var answer = '';
    
    numbers.sort((a,b)=> {
        const strA = String(a);
        const strB = String(b);
        return strB + strA > strA+ strB ? 1: -1;
    });
    
    
    numbers.forEach((a)=> {
        answer += String(a)
    });
    
    return answer[0] === '0' ? '0' : answer;
}