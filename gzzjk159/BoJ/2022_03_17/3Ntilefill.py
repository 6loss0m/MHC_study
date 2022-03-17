n = int(input())
dp = [0 for _ in range(31)]
dp[2] = 3
for i in range(4,n+1) :
    if i%2 == 0 :
        dp[i] = dp[i-2] * 3 + sum(dp[:i-2]) * 2 + 2
    else :
        dp[i] = 0
print(dp[n])
#도움 얻은 링크 https://0equal2.tistory.com/114
#https://jyeonnyang2.tistory.com/51