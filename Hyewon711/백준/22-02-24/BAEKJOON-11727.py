# 2xn 타일링2 / 시간복잡도 O(n)
# n[1] = 1, n[2] = 3, n[3] = 3, n[4] = 5, n[5] = 8 ... 피보나치 수열
# 점화식 dp[n] = dp[n-1] + dp[n-2] + dp[n-2] 

n = int(input())
dp = [0] * 1001
dp[1] = 1
dp[2] = 3

for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-2]
                         
print(dp[n] % 10007)