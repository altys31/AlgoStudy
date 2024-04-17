def solution(numbers, hand):
    answer = ''
    left_bt = {1:(0,0),4:(0,1),7:(0,2),"*":(0,3)}
    right_bt = {3:(2,0),6:(2,1),9:(2,2),"#":(2,3)}
    center_bt = {2:(1,0),5:(1,1),8:(1,2),0:(1,3)}
    left_spot = (0,3)
    right_spot = (2,3)
    
    for a in numbers:
        if a in left_bt.keys():
            left_spot = left_bt[a]
            answer += "L"
            
        elif a in right_bt.keys():
            right_spot = right_bt[a]
            answer += "R"
            
        elif a in center_bt.keys():
            left_distance = abs(left_spot[0] - center_bt[a][0]) + abs(left_spot[1] - center_bt[a][1]) 
            right_distance = abs(right_spot[0] - center_bt[a][0]) + abs(right_spot[1] - center_bt[a][1])
            
            if left_distance < right_distance:
                left_spot = center_bt[a]
                answer += "L"
            elif right_distance < left_distance:
                right_spot = center_bt[a]
                answer += "R"
            else:
                if hand == "left":
                    left_spot = center_bt[a]
                    answer += "L"
                else:
                    right_spot = center_bt[a]
                    answer += "R"
                
    return answer