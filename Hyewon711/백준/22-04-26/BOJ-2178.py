# BOJ 2178 - 미로 탐색
# 미로찾기 유형은 DFS / BFS로 많이 출제되니 자세히 공부하기
# 미로찾기 핵심 -> 최단거리일 경우 BFS로 풀기 ! dx, dy 방향 탐색에 유의.
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]


import sys
from collections import deque
input = sys.stdin.readline

n, m = list(map(int, input().split())) # N개의 줄에는 M개의 정수 미로
maze = [] # 미로 입력받을 변수
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    maze.append(list(map(int, input().strip())))

def bfs(x, y): # 너비우선탐색 bfs
    q = deque() # deque를 이용
    q.append((x, y)) # deque에 x, y좌표 추가
    while q: # deque를 전부 도는 동안 반복
        x, y = q.popleft() # 선입선출, 왼쪽(앞)에서부터 pop
        for i in range(4): # 상하좌우 값 확인 (4방향)
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m: # 만약 상하좌우 중 막다른 길(벽)이 있는 경우 continue
                continue
            if maze[nx][ny] == 0: # 0인 경우 막힌 미로, 이동할 수 없으므로 continue
                continue
            elif maze[nx][ny] == 1: # 1인 경우 이동할 수 있다.
                q.append((nx, ny)) # 좌표를 deque에 추가
                maze[nx][ny] = maze[x][y] + 1 # 현재위치에서 이동 -> nx ny

bfs(0, 0)
print(maze[n-1][m-1]) # 행렬은 0,0부터 시작하므로 -1을 해주어야한다.

