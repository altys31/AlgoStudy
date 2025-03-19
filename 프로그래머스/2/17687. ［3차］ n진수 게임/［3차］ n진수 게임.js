function solution(n, t, m, p) {
    var answer = '';
    var numeral = [0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F'];
    var game = '';
    
    for(let i = 0; i < t*m+p; i++){
        game += i.toString(n).toUpperCase();
    }
    
    for(let i = 0; i< t; i++){
        answer += game[i*m+p-1];
    }
    
    return answer;
}