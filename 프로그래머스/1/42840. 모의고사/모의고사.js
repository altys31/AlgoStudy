function solution(answers) {
    var firstStudent = [1,2,3,4,5]
    var secondStudent = [2,1,2,3,2,4,2,5]
    var thirdStudent = [3,3,1,1,2,2,4,4,5,5]
    var correctCount = [0,0,0];
    var answer = [];
    
    for(let i = 0; i< answers.length; i++){
        if(answers[i] === firstStudent[i%5])
            correctCount[0]++
        if(answers[i] === secondStudent[i%8])
            correctCount[1]++
        if(answers[i] === thirdStudent[i%10])
            correctCount[2]++
    }

    var maxValue = Math.max.apply(null, correctCount);

    correctCount.map((a,i)=> maxValue === a ? answer.push(i+1) : '')
    
    return answer;
}