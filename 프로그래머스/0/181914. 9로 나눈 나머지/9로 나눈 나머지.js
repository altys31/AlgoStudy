function solution(number) {
    var num = 0
    var answer = number.split("")
    answer.forEach((t)=> num += parseFloat(t))
    
    num %= 9
    return num;
}