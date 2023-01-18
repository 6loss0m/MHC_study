"""
    1, 2, 3 더하기 (3)
    점화식을 세우는 것이 중요!
    이전에 푼 15990과는 달리 같은 수를 연속으로 사용해도 된다.
    1 : 1개
    2 : 2개
    3 : 4개
    4 : 7개
    5 : 13개
    6 : 24개
    dp[i] = dp[i-1]*2-1 이 되는 줄 알았는데 6을 확인해보니 아님.
    다시 점화식을 풀어보니 -3번째, -2번째, -1번째를 더하면 해당하는 수의 값이 나오는 것이었다.


"""

import sys

input = sys.stdin.readline

dp = [0] * 1000001
num = 1000000009
dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, 1000001):
    dp[i] = (dp[i-3]+dp[i-2]+dp[i-1]) % num

T = int(input())
for i in range(T):
    n = int(input())
    print(dp[n])