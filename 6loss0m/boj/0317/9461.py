# 파도반 수열
# https://www.acmicpc.net/problem/9461
# 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
# P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

# 점화식 P(N) = P(N-2) + P(N-3)
def sol(n):
    dp = [0]*(n+1)

    dp[1] = 1
    if n == 2:
        dp[2] = 1
    elif n > 2:
        dp[2] = 1
        dp[3] = 1
        for i in range(4,n+1):
            dp[i] = dp[i-2] + dp[i-3]
    return dp[n]


t = int(input())
result = [0]*t

for i in range(t):
    n = int(input())
    result[i] = sol(n)

for i in result:
    print(i)