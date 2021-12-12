def solution(n, times):
    left,right = 1, n * max(times)
    
    while left <= right:
        # 중간값 설정( 시간 설정 )
        mid = (left + right) // 2
        people = 0       
        
        for t in times:
            people += mid // t # 주어진 시간동안 처리할 수 있는 사람 수
        
        if people >= n: # n보다 큰 경우 : 시간내에 처리 가능
            answer = mid
            right = mid - 1 # 시간을 더 줄임
        else: # n 보다 작은 경우 : 심사처리 불가능
            left = mid + 1 # 시간을 더 줌
        
    return answer