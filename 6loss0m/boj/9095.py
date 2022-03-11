n = int(input())

def sol(p):
    dp = [0] * (p+1)
    dp[1] = 1
    if p == 2:
        dp[2] = 2
    if p > 2 :
        dp[2] = 2
        dp[3] = 4
        for i in range(4,p+1):
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    return dp[p]
    
for _ in range(n):
    a = int(input())
    print(sol(a))