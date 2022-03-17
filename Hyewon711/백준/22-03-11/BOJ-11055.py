# 백준-11055 가장 큰 증가 부분 수열 
# 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램이다.

n = int(input())
arr = list(map(int, input().split()))

dp = [0] * n # 인덱스 위치 중, 가장 큰 부분의 수열 합을 구하는 dp 
dp[0] = arr[0] 

for i in range(1, n):
    dp[i] = arr[i] 
    for j in range(i): # 현재 인덱스 (i) 와 이전 인덱스 (j) 값을 비교하고, 
        if arr[i] > arr[j]: # 현재 인덱스 i가 이전 인덱스  j보다 큰 경우
            dp[i] = max(dp[i], dp[j] + arr[i]) # 현재 인덱스 위치 dp[i]에 가장 큰 증가 부분 수열의 합과 이전 인덱스 위치에 가장 큰 증가 부분 수열의 합을 비교

print(max(dp))