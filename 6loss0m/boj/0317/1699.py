# 제곱수의 합
# https://www.acmicpc.net/problem/1699
# 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 '최소개수'를 구하는 프로그램을 작성하시오.
# 입력 : 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)
# 출력 : 주어진 자연수를 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.
# 참고 : https://chanhuiseok.github.io/posts/baek-10/
# 1 = 1**2
# 2 = 1**2 + 1**2

n = int(input())
dp = [0]
for i in range(1,n+1):
    dp.append(i)

for i in range(1,n+1):
    for j in range(1,i) :
        if j*j > i : # j*j = j**2
            break
        # min, max : O(N)
        #dp[i] = min(dp[i],dp[i-j*j]+1)
        # min 넣으면 시간초과나서 if로 변경
        if dp[i] > dp[i-j*j]+1:
            dp[i] = dp[i-j*j]+1

print(dp[i])