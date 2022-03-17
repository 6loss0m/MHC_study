n = int(input())

for i in range(n):
    dp =[]
    q = int(input())
    for j in range(2):
        dp.append(list(map(int,input().split())))
    for k in range(1,q):
        if k == 1:
            dp[0][k] += dp[1][k-1]
            dp[1][k] += dp[0][k-1]
        else:
            dp[0][k] += max(dp[1][k-1],dp[1][k-2])
            dp[1][k] += max(dp[0][k-1],dp[0][k-2])
    print(max(dp[0][q-1],dp[1][q-1]))