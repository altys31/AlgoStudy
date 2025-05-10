def solution(s):
    answer = 0
    s = s.split(" ")
    int_list =[]
    for a in s:
        int_list.append(int(a))
    int_list.sort()
    return str(int_list[0])+" "+str(int_list[-1])