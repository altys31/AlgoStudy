function solution(numLog) {
    var num = 0
    var answer = ''
    var count = 0; 
    for (var i = 1; i < numLog.length; i++) {
        switch (numLog[i] - numLog[i - 1]) {
            case 1:
                answer += 'w'
                num += 1
                break
            case -1:
                answer += 's'
                num -= 1
                break
            case 10:
                answer += 'd'
                num += 10
                break
            case -10:
                answer += 'a'
                num -= 10
                break
        }
        count++
    }
    return answer;
}