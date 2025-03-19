function solution(s) {
    var answer = [];
    const arr = JSON.parse(s.replace(/{/g, "[").replace(/}/g, "]"));
    arr.sort((a,b)=>a.length-b.length);

    for(let i =0 ; i<arr.length; i++){
        for(const a of arr[i]){
            if(!answer.includes(a))
                answer.push(a);
        }
    }
    
    return answer;
}