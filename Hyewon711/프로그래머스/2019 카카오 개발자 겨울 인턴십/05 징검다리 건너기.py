def solution(stones, k): # 정확성과 효율성 고려, 이진 탐색
    # stones 배열의 원소는 1 이상 200,000,000 이하인 자연수 -> 범위가 너무 크므로 이진 탐색 유형의 문제인지 고려하기
    
    # 이진 탐색 범위 : 1 ~ 최대 건널 수 있는 사람 수
    # k는 1이상, 돌의 개수 길이 이하인 자연수 
    left = 1 # 돌의 최소값
    right = max(stones) # 돌의 최댓값 
    answer = 0
    
    while left <= right: # 이진탐색 시작
        blankCount = 0 # 사용할 수 없는 돌의 개수 
        mid = (right + left) // 2 # 이진 탐색이기에 절반으로 나누어 중간 값을 구한다. (징검다리를 건널 수 있는 수) 

        
        for stone in stones: # 징검다리 반복문
            if stone - mid <= 0: # 만약 현재 돌이 중간값보다 작은 경우
                blankCount += 1 # 공백 카운트 +1 
            else:
                blankCount = 0 # 중간 값 보다 큰 경우 공백 카운트는 0으로 

            if blankCount >= k: 
                break # 만약 공백 카운트가 뛸 수 있는 수 (k) 보다 크거나 같다면 더이상 뛸 수 없으므로 반복문을 멈춘다.

        # 카운트 된 공백 값을 k 값과 비교한다.
        if blankCount < k: # 공백 카운트가 k 보다 작다면  
            left = mid + 1 # left 범위를 늘린다.
        else: # 공백 카운트가 k보다 크거나 같은 경우
            answer = mid # 정답 값에 mid를 넣고 
            right = mid - 1 # right 범위를 줄인다.
    
    return answer