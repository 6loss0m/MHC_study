def solution(brown, yellow):
    answer = []
    total = brown+yellow
    
    for i in range(3,brown//2):
        col = brown/2 - i + 2
        #print(i*col)
        if total == i*col:
            answer.append(col)
            answer.append(i)
            return answer