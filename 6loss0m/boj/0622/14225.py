# 부분수열의 합
# dp 사용
from itertools import combinations

dp =  [0]*2000001
dp[0] = 1

n = int(input())
data =  list(map(int, input().split()))

for i in range(1, n+1): # n번 돌면서
    for j in combinations(data, i): # i개 뽑아내는 조합을 가져온다.
        dp[sum(j)] = 1

print(dp.index(0))

# dfs
import sys
n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
answer = []

def dfs(value, index): # S = [5,1,2]
    if index == n:
        return 0;
    value += arr[index]
    answer.append(value)
    dfs(value, index+1) # 5다 음 1, 2
    value -= arr[index]
    dfs(value, index+1) # 5를 건너뛴 1, 2

dfs(0,0)
a = set(answer)
for num in range(1, 2000000):
    if num not in a:
        print(num)
        break