var spellList = ['','A','E','I','O','U'];

function solution(word) {
    var answer = 0;
    var list = [];
    dfs(list, '', 0);
    list.shift();
    
    return list.indexOf(word)+1;
}

const dfs = (list, word, lng) => {
    if(lng === 5){
        list.push(word)
        return;
    }
    
    for(let i = 0; i< 6; i++){
        if(i === 0)
            list.push(word);
        else {
            const nextWord = word+spellList[i]; 
            dfs(list, nextWord, lng+1);
        }
    }
}

