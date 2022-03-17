import math

n = int(input())

# 각각의 수를 1^2 으로 표현할때가 가장 큰 횟수이기 때문에 인덱스와 동일하게 x로 초기화
dp = [x for x in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, int(math.sqrt(i) + 1)):
        if dp[i] > (dp[i - j * j] + 1):
            dp[i] = dp[i - j * j] + 1

print(dp[n])
#도움 받은 링크 https://ji-gwang.tistory.com/280