function solution(skill, skill_trees) {
    var answer = 0;
    
    for(const skillOrder of skill_trees){
        var order = 0;
        var isPossible = true; 
        
        for(let i = 0; i< skillOrder.length; i++){
            
            if(skillOrder[i] === skill[order]){
                order++;
            }
            else if(skill.indexOf(skillOrder[i]) != -1){
                isPossible = false;
                break;
            }
            
        }
        
        if(isPossible)
            answer++;

    }
 return answer;
}