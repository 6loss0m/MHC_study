# BOJ 9019 - DSLR
# 파이썬 -> 시간초과, pypy로 돌려야 정답처리
from collections import deque

def bfs():
    q = deque()
    q.append([A, ''])
    visited[A] = 1
    while q:
        x, y = q.popleft()
        if x == B:
            print(y)
        D = x*2 % 10000
        if not visited[D]:
            visited[D] = 1
            q.append([D, y + 'D'])
        S = x - 1 if x != 0 else 9999
        if not visited[S]:
            visited[S] = 1
            q.append([S, y + 'S'])
        L = x % 1000 * 10 + x // 1000
        if not visited[L]:
            visited[L] = 1
            q.append([L, y + 'L'])
        R = x % 10 * 1000 + x // 10
        if not visited[R]:
            visited[R] = 1
            q.append([R, y + 'R'])

T = int(input())
for _ in range(T):
    A, B = map(int, input().split(' '))
    visited = [0] * 10000
    bfs()