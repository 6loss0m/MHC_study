import sys
import collections

input = sys.stdin.readline

n, m = map(int, input().split())
maze = [list(map(int, ' '.join(input()).split())) for _ in range(n)]

# 이동
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

Q = collections.deque([(0, 0)])

while Q:
    x, y = Q.popleft()
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if maze[nx][ny] == 1:
                # 방문
                maze[nx][ny] = maze[x][y] + 1
                Q.append((nx, ny))

print(maze[n - 1][m - 1])