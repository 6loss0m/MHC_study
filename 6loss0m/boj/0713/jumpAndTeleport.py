def solution(N):
    answer = 0
    while N > 0:
        answer += N % 2
        N //= 2
    return answer

# https://hkim-data.tistory.com/75