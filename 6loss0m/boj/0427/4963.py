# 섬의 개수
# dfs
import sys
sys.setrecursionlimit(-1)

def dfs(y, x):
    graph[y][x] = 0
    for dy, dx in d:
        Y, X = y+dy, x+dx
        if (0 <= Y < h) and (0 <= X < w) and graph[Y][X] == 1:
            dfs(Y, X)

while 1:
    w, h = map(int, input().split())
    if w == h == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(h)]
    d = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                dfs(i, j)
                cnt += 1
    print(cnt)

# bfs
from collections import deque

def bfs(y, x):
    queue = deque()
    queue.append((y, x))
    while queue:
        y, x = queue.popleft()
        for dy, dx in d:
            Y, X = y+dy, x+dx
            if (0 <= Y < h) and (0 <= X < w) and graph[Y][X] == 1:
                graph[Y][X] = 0
                queue.append((Y, X))

while 1:
    w, h = map(int, input().split())
    if w == h == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(h)]
    d = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                bfs(i, j)
                cnt += 1
    print(cnt)