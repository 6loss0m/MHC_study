# 외판원 순회 2
# 모든 가지수는 N x (N-1) x ... x 1 개
# 예시로 주어진 N=4 는 총가지수 24개
# 0 1 2 3 0
# 0 1 3 2 0
# 0 2 1 3 0
# 0 2 3 1 0
# 0 3 1 2 0
# 0 3 2 1 0
# -----------
# 1 0 2 3 1
# 1 0 3 2 1
# 1 2 0 3 1
# 1 2 3 0 1
# 1 3 0 2 1
# 1 3 2 0 1
# -----------
# 모든 경우의 수 에서 최소값 구하기

'''
완전탐색은 시간초과
from itertools import permutations

N = int(input())
num = [list(map(int,input().split())) for _ in range(N)]
order = [i for i in range(N)]

def func(num, list):
    sum = 0
    for j in range(len(list)-1):
        start = list[j]
        end = list[j+1]
        if num[start][end] == 0:
            return False
        else:
            sum += num[start][end]
    start = list[j+1]
    end = list[0]
    if num[start][end] == 0:
        return False
    else:
        sum += num[start][end]
    return sum
min = 1000000 * N # 각 성분의 최대값이 1,000,000이므로 최대는 1,000,000 x N
find = 0
for i in permutations(order):
    sum = func(num, i)
    if sum != False:
        if min > sum:
            min = sum
print(min)
'''