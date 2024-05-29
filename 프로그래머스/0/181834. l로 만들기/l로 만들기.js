function solution(myString) {
    const alphabet = ['a','b','c','d','e','f','g','h','i','j','k']
    var answer = ''
    
    Array.from(myString).forEach((t)=> {
        if(alphabet.includes(t)){
            answer += 'l'
        }
        else{
            answer += t
        }
    })
    
    return answer;
}