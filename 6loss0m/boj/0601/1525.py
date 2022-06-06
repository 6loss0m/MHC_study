# 퍼즐
# BOJ 1525
from collections import deque

def bfs(q):
    while q:
        d = q.popleft()
        if d == 123456789:
            print(dist[d])
            return
        s=str(d)
        zero=s.find('9')
        # x는 행 y는 열
        x,y = zero//3, zero%3
        for dx, dy in (1,0), (-1,0), (0,1), (0,-1):
            nx, ny = x+dx, y+dy
            if 0<=nx<3 and 0<=ny<3:
                k = nx*3+ny
                ns = list(s)
                ns[k], ns[zero] = ns[zero], ns[k]
                nd = int(''.join(ns))
                if not dist.get(nd):
                    dist[nd]=dist[d]+1
                    q.append(nd)
    print(-1)


q = deque()
# dist의 key:value=정수:옮긴횟수
dist = {}
puzzle = [list(map(int, input().split())) for _ in range(3)]
m=0
for i in range(3):
    for j in range(3):
        n = puzzle[i][j]
        if n==0:
            n=9
        m = m*10 + n
q.append(m)
dist[m]=0
bfs(q)