function solution(record) {
    var answer = [];
    
    const map = {};
    
    for(const a of record){
        var messege = a.split(" ");
        if(messege[0] === 'Enter' || messege[0] === 'Change'){
            map[messege[1]] = messege[2];
        }
    }
    
    for(const a of record){
        var messege = a.split(" ");
        if(messege[0] === 'Enter'){
            answer.push(map[messege[1]] + '님이 들어왔습니다.')
        }
        if(messege[0] === 'Leave'){
            answer.push(map[messege[1]] + '님이 나갔습니다.');
        }
    }
    
    return answer;
}