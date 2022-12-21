"""
17086 - 아기 상어 2
N * M 크기의 공간에서 상어가 있는 칸을 기준으로 안전 거리 중 가장 큰 값을 출력한다.
상어는 8방향으로 이동할 수 있다.
bfs로 완전탐색을 하고, 지나온 경로를 따라 카운트 해준 다음 안전거리가 큰 값을 출력한다.
안전거리가 겹치는 칸이 있을 수 있기에 이미 방문했다면 continue로 넘겨주자

2 <= n, m <= 50 의 크기 제한이 있다.
시간제한 2초 ( 약 2억번 이하 연산)

"""
import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
dist = 0 # 안전거리 크기
state = [] # 상어가 있는 공간
for _ in range (n) :
    state.append(list(map(int, input().split())))

q = deque() # 데큐
dx = [-1, -1, -1, 0, 1, 1, 1, 0]
dy = [-1, 0, 1, 1, 1, 0, -1, -1]

def bfs():
    while q : # 큐가 빌 때까지 반복
        x, y = q.popleft()

        for a in range (8): # 8방향
            nx, ny = x+dx[a], y+dy[a] # 8방향을 탐색
            if nx < 0 or nx >= n or ny < 0 or ny >= m : # 테두리를 벗어난다면 continue
                continue
            if state[nx][ny] == 0 : # 아직 방문하지 않았다면?
                state[nx][ny] = state[x][y]+1 # 현재 좌표에 이전좌표에 저장된 값+1 하여 넣기
                q.append((nx, ny)) # 현재 좌표를 큐에 넣기

for x in range(n):
    for y in range(m):
        if state[x][y] == 1 : # 상어가 있는 좌표를 큐에 넣어야한다.
            q.append((x,y))

bfs()

for i in range(n):
    for j in range(m) :
        dist = max(dist, state[i][j])

print(dist-1)