def solution(numbers, target):
    answer = 0
    queue = [[numbers[0],0], [-1*numbers[0],0]]
    n = len(numbers)
    while queue:
        temp, idx = queue.pop()
        idx += 1
        if idx < n:
            queue.append([temp+numbers[idx], idx])
            queue.append([temp-numbers[idx], idx])
        else:
            if temp == target:
                answer += 1
    return answer
#큐에 인덱스와 그 인덱스에서 가질수 있는 값들을 넣어놓고
#pop을 했을 때 인덱스가 숫자가 맞는지 비교하고 만약 맞을 때 타겟과 비교해서 맞으면 
#answer+1 해주는 코드이다

#while문 하나이기 때문에 n^1같습니다.
