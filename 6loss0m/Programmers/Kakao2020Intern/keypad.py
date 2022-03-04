def solution(numbers, hand):
    # number 0123456789*#
    pos=[[3,1],[0,0],[0,1],[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2],[3,0],[3,2]]
    lpos = 10
    rpos = 11
    answer = ''
    for i in numbers:
        # 왼손을쓰는경우
        if i in [1,4,7]:
            answer += 'L'
            lpos = i
        # 오른손을 쓰는경우 
        elif i in [3,6,9]:
            answer += 'R'
            rpos = i
        # 양손중에 골라야 하는경우
        else:
            ldis = abs(pos[lpos][0]-pos[i][0]) + abs(pos[lpos][1]-pos[i][1])
            rdis = abs(pos[rpos][0]-pos[i][0]) + abs(pos[rpos][1]-pos[i][1])
            if ldis > rdis :
                answer += 'R'
                rpos = i
            elif ldis < rdis :
                answer += 'L'
                lpos = i
            else :
                if hand == 'right':
                    answer += 'R'
                    rpos = i
                elif hand == 'left':
                    answer += 'L'
                    lpos = i
                
        
    return answer