# 백준 - 11054 가장 긴 바이토닉 부분 수열 
# 바이토닉 수열 : 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족
# Sk 기준점을 구하는 것이 중요 

n = int(input())
arr = list(map(int, input().split()))

dp1 = [1] * n
dp2 = [1] * n

# 가장 긴 증가하는 부분 수열 (11053)
for i in range(1, n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp1[i] = max(dp1[i], dp1[j] + 1)

# 가장 긴 감소하는 부분 수열 (11722)
for i in range(n - 1, -1, -1): #n-1부터 0까지 -1씩 감소하면서 반복문 
    for j in range(i, n):
        if arr[i] > arr[j]:
            dp2[i] = max(dp2[i], dp2[j] + 1)

print(max([a + b for a, b in zip(dp1, dp2)]) - 1) # zip: 같은 인덱스 짝별로 묶어 튜플에 담아 반환