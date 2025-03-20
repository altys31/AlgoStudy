class Node {
    constructor(num){
        this.num = num;
    }
}

var answer = 0;

function solution(n, computers) {
    var visited = Array(n);
    visited.fill(false, 0, n);
    
    var queue = [];
    
    for(let i =0 ; i< n; i++){
        if(!visited[i]){
            queue.push(new Node(i));
            visited[i] = true;
            bfs(queue,visited,computers,n);
            answer++;
        }
    }
    
    return answer;
}

const bfs = (queue, visited,computers, n) => {
    while(queue.length > 0){
        const node = queue.shift();
        var num = node.num;
        
        for(let i = 0; i< n; i++){
            
            if(num === i)
                continue;
            
            if (computers[num][i] === 1 && !visited[i]){
                visited[i] = true;
                queue.push(new Node(i));
            }
        }
    }
}