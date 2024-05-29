function solution(str_list, ex) {
    var answer = '';
    str_list = str_list.filter((t) => !t.includes(ex))
    str_list.forEach((t) => answer = answer+ t)
    return answer;
}