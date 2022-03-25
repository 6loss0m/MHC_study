# 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
# 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다. 
# 마지막 도착 계단은 반드시 밟아야 한다.
# 계단 stairs

n = int(input())
stairs = [0] * 301
dp = [0] * 301

for i in range(1, n + 1):
    stairs[i] = int(input()) #계단의 개수 

# 계단의 개수가 1인 경우 점수의 최대값은 1
# 계단의 개수가 2인 경우 점수의 최대값은 이전 계단과 마지막 계단 모두 밟아야 하는 것이다.

dp[0] = stairs[0]
dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]
dp[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3]) 

for i in range(4, n+1):
        dp[i] = max(dp[i-3] + stairs[i] + stairs[i-1], dp[i-2] + stairs[i])
# 점화식은 따라서 위와같이 표현할 수 있다.
print(dp[n])