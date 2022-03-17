# 계단오르기
# https://www.acmicpc.net/problem/2579
# 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.


# 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
# 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
# 마지막 도착 계단은 반드시 밟아야 한다.

n = int(input())
step = [0]*(n+1)
for i in range(1,n+1):
    step[i] = int(input())
dp = [0]*(n+1)

dp[1] = step[1]
if n == 2:
    dp[2] = step[1]+step[2]
elif n > 2:
    dp[2] = step[1]+step[2]
    dp[3] = max(step[1]+step[3], step[2]+step[3])
    # 마지막 계단은 무조건 밟아야 하기 때문에 step[i]는 필수로 더함
    # 그 이후 i가 5인 경우
    # 1. 4번째 계단을 밟고 올라온 경우
    #    바로 전 계단값을 더하고, dp[4] 값 더함
    # 2. 3번째 계단을 밟고 올라온 경우
    #    바로 전 계단값을 더하지 않고, dp[4] 값 더함
    for i in range(4, n+1):
        #print(dp[i-3]+step[i-1]+step[i],dp[i-2]+step[i])
        dp[i] = max(dp[i-3]+step[i-1]+step[i],dp[i-2]+step[i])
#print(dp)
print(dp[n])

