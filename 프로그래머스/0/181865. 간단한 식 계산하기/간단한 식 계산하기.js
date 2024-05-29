function solution(binomial) {
    var answer = 0;
    var list
    list = binomial.split(" ")
    list[0] = parseFloat(list[0])
    list[2] = parseFloat(list[2])
    if(list[1] == '+')
        answer = list[0]+list[2]
    else if (list[1] == '-' )
        answer = list[0]-list[2]
    else
        answer = list[0]*list[2]
    return answer;
}