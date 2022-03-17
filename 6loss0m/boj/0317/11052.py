# 카드 구매
# https://www.acmicpc.net/problem/11052
# 입력 : 첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)
#       둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)
# 출력 : 첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최댓값을 출력한다.

# d[1] = p[1]
#
# d[2] = d[1] + p[1] or d[0] + p[2]
#
# d[3] = d[2] + p[1] or d[1] + p[2] or d[0] + p[3]
#
# d[4] = d[3] + p[1] or d[2] + p[2] or d[1] + p[3] or d[0] + p[4]
n = int(input())
price = [0]+list(map(int,input().split()))
dp = [0]*(n+1)
for i in range(n):
    dp[i+1] = price[i+1]

for i in range(2, n + 1):
    for j in range(1, i + 1):
        if dp[i] < dp[i - j] + price[j]:
            dp[i] = dp[i - j] + price[j]
print(dp[n])
#print(card,dp)
