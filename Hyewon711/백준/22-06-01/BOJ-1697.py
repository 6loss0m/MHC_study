# BOJ 1697 - 숨바꼭질

from collections import deque

def bfs():
    q = deque()
    q.append(n)
    while q:
        x = q.popleft()
        if x == k :
            print(dist[x])
            break
        for nx in ( x-1, x+1, x*2) :
            if 0 <=nx <= MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                q.append(nx)

MAX = 10 ** 5
dist = [0] * (MAX+1)
n, k = map(int, input().split())

bfs()