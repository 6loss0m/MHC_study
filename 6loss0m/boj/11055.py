n = int(input())
seq = list(map(int,input().split()))
dp = [_ for _ in seq]
for i in range(n) :
    for j in range(i):
        if seq[i] > seq[j]:
            dp[i] = max(dp[i],dp[j]+seq[i])
print(dp)
print(max(dp))


# 반례
# 2 1 5 6 7

# 예시
# 10
# 1 100 2 50 60 3 5 6 7 8