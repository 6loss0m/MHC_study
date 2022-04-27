# 이친수
# https://www.acmicpc.net/problem/2193

# n = 1 -> 1 [1]
# n = 2 -> 10 [1]
# n = 3 -> 101,100 [2]
# n = 4 -> 1010,1001,1000 [3]
# n = 5 -> 10101,10100,10010,10001,10000 [5]

# n = ? -> 10...
n = int(input())
dp = [0]*(n+1)

dp[1] = 1
if n > 1 :
    dp[2] = 1
    for i in range(3,n+1):
        dp[i] = dp[i-1]+dp[i-2] # 점화식
print(dp[n])