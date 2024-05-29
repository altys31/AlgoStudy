function solution(my_string) {
    var answer = [];
    for(var i = 0; i<my_string.length; i++){
        var word = ''
        for(var j = i; j<my_string.length; j++){
           word += my_string[j]
        }
         answer.push(word)
    }
    answer.sort()
    
    return answer;
}