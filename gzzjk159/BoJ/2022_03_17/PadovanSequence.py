t=int(input())
for i in range(t):
    n=int(input())
    dp=[1,1,1,2]
    if n<4:
        print(dp[n-1])
    else:
        for i in range(4,n):
            dp.append(dp[i-2]+dp[i-3])
        print(dp[n-1])