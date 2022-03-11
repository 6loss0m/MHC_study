def solution(stones, k):
    start, end = 1, max(stones) 
    tmp = []
    answer = 0
    while start <= end:
        blankCount = 0
        mid = (start + end) // 2 # 징검다리를 건널 수 있는 수 
        
        for stone in stones:
            if stone - mid <= 0:
                blankCount += 1
            else:
                blankCount = 0
                
            if blankCount >= k:
                break

        if blankCount < k:
            start = mid + 1 # 정답이 될 수 있는 값
        elif blankCount == k:
            answer = mid
        else:
            #answer = mid
            end = mid - 1
    
    return answer