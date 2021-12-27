def solution(answers):
    a1 = [1,2,3,4,5]
    a2 = [2,1,2,3,2,4,2,5]
    a3 = [3,3,1,1,2,2,4,4,5,5]
    count = [0,0,0]
    
    answer = []
    
    for idx in range(len(answers)):
        n1 = idx % len(a1)
        n2 = idx % len(a2)
        n3 = idx % len(a3)
        
        if a1[n1] == answers[idx]:
            count[0] += 1
        if a2[n2] == answers[idx]:
            count[1] += 1
        if a3[n3] == answers[idx]:
            count[2] += 1
            
    k = max(count)
    if k == count[0]:
        answer.append(1)
    if k == count[1]:
        answer.append(2)
    if k == count[2]:
        answer.append(3)
    return answer
