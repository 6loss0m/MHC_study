from collections import deque

def solution(people, limit):
    answer = 0
    people.sort()

    # 보트는 2명씩만 탈 수 있고 무게 제한도 있음.
    people = deque(people)
    
    while people:
        if len(people) >= 2:
            answer +=1
            if people[0] + people[-1] <= limit:
                people.pop()
                people.popleft()
            else:
                people.pop()
        else:
            people.pop()
            answer += 1
            
    return answer
