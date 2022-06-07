# 1,2,3 더하기
# 1. 완전탐색
import itertools

arr = [1,2,3]
N = int(input())
n = []
for _ in range(N):
    n.append(int(input()))

res = []
for x in n:
    cnt = 0
    for i in range(1,x+1):
        for j in itertools.product(arr,repeat=i):
            #print(j)
            if(sum(j) == x):
                cnt += 1
    res.append(cnt)
print(*res,sep="\n")

'''
# 2. 재귀
import sys
input = sys.stdin.readline

def go(sum, goal):
    if sum > goal:
        return

    if sum == goal:
        global answer
        answer += 1
        return

    now = 0

    for i in range(1, 4):
        go(sum + i, goal)

n = int(input())
answer = 0

for _ in range(n):
    goal = int(input())
    go(0, goal)
    print(answer)
    answer = 0
'''