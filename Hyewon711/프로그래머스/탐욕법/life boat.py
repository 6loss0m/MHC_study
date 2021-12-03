def solution(people, limit):
    answer = 0
    people.sort()

    i = 0
    j = len(people) - 1
    while i < j:
        # 최소, 최대 둘이 같이 때
        if people[i] + people[j] <= limit:
            j -= 1
            i += 1
            answer += 1
        
        # 최대 혼자 탈 떄
        else:
            j -=1
            answer += 1
    
    if i == j:
        answer += 1
        
    return answer