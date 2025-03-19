class Node {
    constructor(x, y, time){
        this.x = x;
        this.y = y;
        this.time = time; 
    }
}

const dx = [0,1,0,-1];
const dy = [1,0,-1,0];
var n = 0;
var m = 0;
var answer = -1;


function solution(maps) {
    
    n = maps[0].length;
    m = maps.length;
    
    var queue = [new Node(0,0,1)];
    var visited = [];
    
    for(let i = 0; i < m; i++){
        var row = [];
        for(let j = 0; j < n; j++){
            row.push(false);
        }
        visited.push(row);
    }
    
    bfs(queue,maps,visited);
    
    return answer;
}

const bfs = (queue,maps,visited) => {
    while(queue.length != 0){
        const node = queue.shift();
        const x = node.x;
        const y = node.y;
        const time = node.time;
        
        if(x === n-1 && y === m-1 && time > answer){
            answer = time;
            break;
        }
        
        for(let i = 0; i<4; i++){
            const ny = node.y+dy[i];
            const nx = node.x+dx[i];
            
            if(nx < n && nx >=0 && ny < m && ny >= 0 && maps[ny][nx] != 0 && !visited[ny][nx]){
                queue.push(new Node (nx,ny,time+1));
                visited[ny][nx] = true; 
            }
        }
        
    }
}