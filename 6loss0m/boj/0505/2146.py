# 다리 만들기

# 1. 섬이 몇개있는지 bfs로 구한다
#
# 2. 섬 중에서 하나를 선택해 섬의 크기를 늘려가면서 다른 섬에 닿을 때까지의 거리를 구한다.
#
# 3. 과정 2를 전체 섬에 대하여 구한 후 최소값을 출력
from collections import deque
import sys

input = sys.stdin.readline
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs1(x, y, cnt):
    q.append([x, y])
    c1[x][y] = cnt
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if a[nx][ny] == 1 and c1[nx][ny] == 0:
                    c1[nx][ny] = cnt
                    q.append([nx, ny])

def bfs2(num):
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if a[nx][ny] == 1 and c1[nx][ny] != num:
                    return c2[x][y]-1
                if a[nx][ny] == 0 and c2[nx][ny] == 0:
                    c2[nx][ny] = c2[x][y] + 1
                    q.append([nx, ny])

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
c1 = [[0]*n for _ in range(n)]
q, q2 = deque(), deque()
cnt = 1

for i in range(n):
    for j in range(n):
        if a[i][j] == 1 and c1[i][j] == 0:
            bfs1(i, j, cnt)
            cnt += 1

ans = sys.maxsize
for k in range(1, cnt):
    q = deque()
    c2 = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if a[i][j] == 1 and c1[i][j] == k:
                q.append([i, j])
                c2[i][j] = 1
    res = bfs2(k)
    ans = min(ans, res)
print(ans)