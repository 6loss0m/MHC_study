# 연속합
# https://www.acmicpc.net/problem/1912
n = int(input())

seq = list(map(int,input().split()))
dp = [0] * n
dp[0] = seq[0]


for i in range(1,n):
    # dp[i-1] + seq[i] 이 현재 값보다 작으면 새출발
    dp[i] = max(seq[i],dp[i-1]+seq[i])
print(max(dp))
