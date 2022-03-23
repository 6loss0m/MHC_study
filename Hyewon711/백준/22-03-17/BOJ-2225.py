# 0부터 n까지 정수 k개를 더해서 합이 n이 되는 경우의 수 
# 덧셈 순서가 바뀐 경우 다른 경우로 센다. 
# 한개의 수를 여러번 쓸 수 있다.

n, k = map(int, input().split())

dp = [[0]*201 for _ in range(201)]

for i in range(201): 
    dp[1][i] = 1 # 1열은 무조건 1
    dp[2][i] = i+1 

for i in range(2, 201): 
    dp[i][1] = i
    for j in range(2, 201): 
        dp[i][j] = dp[i][j-1] + dp[i-1][j]
        dp[i][j] %= 1000000000

print(dp[k][n])