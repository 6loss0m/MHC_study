# BOJ 14225 - 부분수열의 합
# 수열 S의 크기 N이 1 ≤ N ≤ 20 이므로 모든 경우의 수를 모두 탐색하는 브루트포스(완전 탐색)를 이용한다.
# DFS를 이용해 만들어낼 수 있는 부분 수열의 합을 모두 구한 후, 배열 체크를 한다.
# 모든 탐색이 끝나면 False인 첫 번째 인덱스를 출력하고 종료

import sys

input = sys.stdin.readline

n = int(input()) # 수열의 크기
arr = list(map(int, sys.stdin.readline().split())) # 수열의 내용 입력
check = [False]*(n*2000001) # 20 * 100,000 이므로 총 2,000,001
i = 1

def dfs (idx, sum) :
    if idx == n :
        check[sum] = True
        return

    # 현재 숫자를 부분수열에 포함하거나 포함하지 않는다.
    dfs(idx+1, sum + arr[idx])
    dfs(idx+1, sum)

dfs(0, 0)

while True :
    if check[i] == False : # False가 저장된 경우, 나올 수 없는 수이므로
        print(i) # 정답 출력
        break
    i += 1 # 다음 인덱스

""" 조합(combination) 라이브러리 이용한 코드 
from itertools import combinations

dp =  [0]*2000001
dp[0] = 1

n = int(input())
data =  list(map(int, input().split()))

for i in range(1, n+1): # n번 돌면서   
    for j in combinations(data, i): # i개 뽑아내는 조합을 가져온다.
        dp[sum(j)] = 1
    
print(dp.index(0))
"""

""" 완전 간단한 정답......... 
n = int(input())
array = list(map(int, input().split()))
array.sort()

num = 1

for i in array:
    if num < i:
        break
    num += i

print(num)

"""