# 가장 긴 감소하는 부분 수열
# https://www.acmicpc.net/problem/11722
# {10, 30, 10, 20, 20, 10}
# -> {30, 20, 10} 3
n = int(input())
seq = list(map(int,input().split()))
dp = [1]*n # 자기자신 부분수열 기본값 1

for i in range(n) :
    for j in range(i):
        # 현재 수가 비교 수 보다 작은 경우
        # 감소해야 하는 부분 수열이기 때문에 큰값이 나오면 dp 갱신
        if seq[i] < seq[j] :
            # max(현재 자기자신, 큰값이 나온 j값의 dp + 1(자신))
            dp[i] = max(dp[i],dp[j]+1)
#print(dp)
print(max(dp)) # 최대길이 출력