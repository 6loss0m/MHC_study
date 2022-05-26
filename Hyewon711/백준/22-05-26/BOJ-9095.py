# BOJ 9095 - 1, 2, 3 더하기
# 1, 2, 3 더하기 / 시간복잡도 O(n) / DP 문제
# n[1] = 1, n[2] = 2, n[3] = 4, n[4] = 7, n[5] = 13 ...
# 점화식 dp[n] = dp[n-1] + dp[n-2] + dp[n-3] (n > 3)
t = int(input())

def solution(n):
    if n==1:
        return 1
    elif n==2:
        return 2
    elif n==3:
        return 4
    else: return solution(n-1) + solution(n-2) +solution(n-3)

for i in range(t):
    n = int(input())
    print(solution(n))