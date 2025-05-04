function solution(m, n, board) {
    var answer = m*n;
    
    var checkX = [0,1,1,0];
    var checkY = [1,0,1,0];
    
    while(true){
        var removeList = [];
        
        for(let i = 0; i<m; i++){
            for(let j = 0; j<n; j++){
                
                var block = board[i][j];
                
                for(let k = 0; k<3; k++){
                    var ny = i +checkY[k];
                    var nx = j +checkX[k];
                    
                    if(ny < m && ny >= 0 && nx < n && ny >= 0 && block !== '0' && board[ny][nx] === block){
                        
                    }
                    else
                        break;
                    
                    if(k === 2){
                        for(let l= 0; l<4; l++){
                            removeList.push([i+checkY[l], j+checkX[l]])
                        }
                    }
                        
                } 
            } 
        }
        
        if(removeList.length === 0)
            break;
        
        for(var target of removeList)
        {
            board[target[0]] = board[target[0]].slice(0,target[1]) + '0' +board[target[0]].slice(target[1]+1,n);
        }

        for(let i = m-1; i > 0; i--){
            for(let j = 0; j<n; j++){
                var upper = i-1;
                if(board[i][j] === '0'){
                    
                    while(upper > 0 && board[upper][j] === '0')
                        upper -= 1;
                    
                    board[i] = board[i].slice(0,j) + board[upper][j] + board[i].slice(j+1,n);
                    board[upper] = board[upper].slice(0,j) + '0' +board[upper].slice(j+1,n);
                }
            }
        }
        
        console.log(board);
        
    }
    for(let i = 0; i< m; i++){
        for(let j =0; j<n; j++){
            if(board[i][j] !== '0'){
                answer--;
            }
        }
    }
    
    return answer;
}