class Word {
    constructor(count, spell) {
        this.count = count;
        this.spell = spell;
    }
}

var answer = 0;

function solution(begin, target, words) {

    var queue = [];
    var visited = Array(words.length);
    visited.fill(false, 0, words.length);
    dfs(begin, words,target, visited, 0);
    return answer;
}

const dfs = (word, words, target, visited, count) => {
    if(word === target){
        if(answer === 0)
            answer = count;
        else
            answer = Math.min(count, answer);
        return;
    }
    
    for(let i = 0; i< words.length; i++){
        if(!visited[i] && isConvertable(word, words[i])){
            visited[i] = true;
            dfs(words[i], words, target, visited, count+1);
            visited[i] = false;
        }
    }
}

const isConvertable = (word1, word2)=>{
    var count = 0;
    for(let i = 0; i<word1.length; i++){
        if(word1[i]===word2[i])
            count ++
    }
    return count === word1.length-1 ? true : false;
}