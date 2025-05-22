function solution(n, stations, w) {
    var answer = 0;
    
    var startIndex = 1; 
    
    for(var station of stations ){
        var blocks = station-w-startIndex;
        
        if(blocks > 0)
            answer += Math.ceil(blocks / (2*w+1));
            
        startIndex = station+w+1;
    }
    
    if(startIndex <= n)
        answer += Math.ceil((n-startIndex+1)/(2*w+1));
    
    return answer;
}