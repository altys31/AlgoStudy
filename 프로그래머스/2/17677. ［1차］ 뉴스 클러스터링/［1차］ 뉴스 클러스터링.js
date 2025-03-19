function solution(str1, str2) {
    var answer = 0;
    
    var leftSet = new Set();
    var rightSet = new Set();
    
    const regex = /[a-zA-Z]/;
    
    var lowerStr1 = str1.toLowerCase();
    var lowerStr2 = str2.toLowerCase();
    
    for(let i = 0 ; i<lowerStr1.length-1; i++){
        if(regex.test(lowerStr1[i]) && regex.test(lowerStr1[i+1])){
            let newStr = lowerStr1[i] + lowerStr1[i+1];
            
            if(leftSet.has(newStr)){
                while(leftSet.has(newStr)){
                    newStr += '1';
                }
                leftSet.add(newStr);
            }
            else
                leftSet.add(newStr);
        }
    }
    
    for(let i = 0; i <lowerStr2.length-1; i++){
       if(regex.test(lowerStr2[i]) && regex.test(lowerStr2[i+1])){
           let newStr = lowerStr2[i] + lowerStr2[i+1];
           
           if(rightSet.has(newStr)){
                while(rightSet.has(newStr)){
                    newStr += '1';
                }
               rightSet.add(newStr);
            }
            else
                rightSet.add(newStr);
           
            }
    }
    
    const unionSet = new Set([...leftSet, ...rightSet]);
    console.log(unionSet);
    
    const intersectionSet = new Set([...leftSet].filter((a)=>{
        if(rightSet.has(a))
            return true;
    }))
    console.log(intersectionSet);
    
    if(unionSet.size != 0)
        answer = Math.trunc(intersectionSet.size*65536/unionSet.size);
    if(unionSet.size === 0 && intersectionSet.size === 0)
        answer = 65536;
    
    return answer;
}