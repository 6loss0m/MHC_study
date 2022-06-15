# BOJ 1182 - 부분수열의 합
from itertools import combinations
n, s = map(int, input().split())
sequence = list(map(int, input().split()))
ans = 0

for i in range(1, n+1):
    subsequence = combinations(sequence, i)
    for j in subsequence:
        if sum(j) == s:
            ans += 1

print(ans)