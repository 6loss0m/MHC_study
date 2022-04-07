n = list(map(int,input()))
l = len(n)
dp = [0 for _ in range(l+1)]
if (n[0] == 0) :
    print("0")
else :
    n = [0] + n
    dp[0]=dp[1]=1
    for i in range(2, l+1):
        if n[i] > 0:
            dp[i] += dp[i-1]
        temp = n[i-1] * 10 + n[i]
        if temp >= 10 and temp <= 26 :
            dp[i] += dp[i-2]
    print(dp[l] % 1000000)