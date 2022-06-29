# 알고스팟
# 우선순위 큐, 다익스트라 유형
# 벽이 없는 곳을 만났을 때는 큐에서 appendleft를 이용하여 먼저 가게 하고
# 벽이 있는 곳을 만나면 그냥 append를 통해 큐에 추가해준다.
import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
miro = [list(map(int,input().rstrip())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

dist = [[-1]*m for _ in range(n)]
q = deque()
q.append((0,0))
dist[0][0] = 0

while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<=nx<m and 0<=ny<n:
            if dist[ny][nx] == -1:
                if miro[ny][nx] == 0:
                    dist[ny][nx] = dist[y][x]
                    q.appendleft((nx, ny))
                else:
                    dist[ny][nx] = dist[y][x]+1
                    q.append((nx, ny))
print(dist[-1][-1])
