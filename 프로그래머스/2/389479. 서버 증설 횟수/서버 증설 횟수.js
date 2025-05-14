function solution(players, m, k) {
    var answer = 0;
    var server = [];
    
    for(var player of players){
        while(player >= m + server.length*m){
            server.push(k);
            //console.log(player +", " + (m + server.length*m))
            answer++;
        }

        
        var newServer = [];
        
        server.forEach((timeLeft)=>{
            timeLeft--;
            if( timeLeft!== 0)
                newServer.push(timeLeft);
        })
        
        server = newServer; 
        
    }
    return answer;
}