function solution(land) {
    var answer = 0;
    var best_list = [[land[0][0],land[0][1],land[0][2],land[0][3]]];
    var index = 0; 
    
    for(let i = 1; i<land.length; i++){
        var newBestCol = best_list[i-1].slice(0,4);
        for(let j = 0; j<4; j++){
            for(let k =0; k<4; k++){
                if(j !== k){
                    newBestCol[k] = Math.max(newBestCol[k], best_list[i-1][j] + land[i][k])
                }
            }
        }
        best_list.push(newBestCol);
    }
    
    for(let i = 0; i<4; i++){
        answer = Math.max(best_list[land.length-1][i],answer);
    }
    return answer;
}