def solution(people, limit):
    answer = len(people)
    p = sorted(people,reverse = True)
    s,e = 0, len(p)-1
    while s < e : 
        if p[s]+p[e] <= limit :
            e-=1
            answer-=1
        s+=1
    return answer

'''
def solution(people, limit):
    people.sort()
    answer = []
    # 비교 시작
    for i in range(len(people)-1):
        for j in range(i+1,len(people)):
            if people[i]+people[j] <= limit:
                answer.append(i)
                answer.append(j)
                break  
    return int(len(answer)/2+(len(people)-len(answer)))
'''