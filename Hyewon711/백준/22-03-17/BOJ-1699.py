# 0 = 0
# 1 = 1 
# 2 = 2
# 3 = 3
# 4 = 1
# 5 = 2 ... 
# i가 5일때, i보다 작거나 같은 제곱수 j는 1, 4이며 dp[i-1]=1, dp[i-4]=1 이다.
# 이때 dp[i-4] = 1 이고 +1 한 값이 dp[5]가 된다. 

# i가 4일때, i보다 작거나 같은 제곱수 j는  1, 4이며 dp[i-1] = 3, dp[i-4] = 0 이다.
# 이때 가장 작은 값은 dp[i-4] = 0 이고 +1 여기에 한 값이 dp[4]가 된다.

n = int(input())
dp = [0] * (n+1) 
 
for i in range(n+1): # i부터 n까지 
    dp[i] = i # dp[i] = i 로 초기화
 
for i in range(1,n+1):
    for j in range(1,i):
        if j*j > i: # 제곱수가 i 보다 커질 때 break
            break
        if dp[i]>dp[i-j*j]+1: 
            dp[i] = dp[i-j*j]+1 #제곱수 표현시 가장 항의 개수가 작은 j 찾기
            
print(dp[n])