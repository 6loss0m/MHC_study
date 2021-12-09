def solution(n, times):
    left = 1 #가장 작은 값에서 모든 사람이 심사를 받는 경우 
    right = n * max(times) #가장 큰 값에서 모든 사람이 심사를 받는 경우

    # 이진 탐색
    while left < right:
        count = 0
        mid = (left + right) // 2 # 중간값을 구한다.

        for time in times: 
            count += mid // time

            #원소를 하나씩 나눈 값들을 모두 더한 후, n과 비교
        if count >= n: #크거나 같다면 right을 좁히고
            right = mid 
        else: # 아닌 경우 left을 좁힌다.
            left = mid + 1 
            
    answer = left # 반복문의 마지막 left가 문제의 최소값이 된다.
    return answer 


