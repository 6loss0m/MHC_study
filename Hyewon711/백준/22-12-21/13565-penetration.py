"""

13565 - 침투
격자의 크기 m*n, 0은 전류가 통하는 길이고 1은 전류가 통하지 않는다.
바깥쪽 (0,0) ~ (0,n) 완전탐색을 돌아서 전류가 차단되면 NO, 전류가 잘 전달되면 (m, 0) ~ (m, n) YES를 출력한다.
시간제한은 1초 (약 1억회 연산)

좌표를 기준으로 4방향을 확인하며 완전탐색을 도는데, 결국 마지막 줄(안쪽)까지 도달할 수 있다면 YES

"""

import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())
figure = [] # 섬유물질 정보
for _ in range (m):
    figure.append(list(map(int, input().rstrip())))

q = deque() # 데큐
visited  = [ [False]*n for _ in range(m) ] # 방문처리 확인용
dx = [0, 1, 0, -1]
dy = [1, 0 , -1, 0]

def bfs() :
    while q: # 큐가 빌 때까지~
        x, y = q.popleft()
        if x == m-1 : # 끝까지 탐색을 하게된 경우 (마지막 줄까지 도달함)
            print("YES")
            return
        for i in range(4) : # 4방향 탐색
            nx, ny = x+dx[i], y+dy[i]
            if nx < 0 or nx>= m or ny < 0 or ny >= n : # 만약 테두리를 벗어난 경우 continue
                continue
            if not visited[nx][ny] and figure[nx][ny] == 0 : # 전류가 흐르는 곳이라면
                q.append((nx, ny))
                visited[nx][ny] = True # 방문처리
    print("NO")

for k in range(n):
    if figure[0][k] == 0 : # 전류가 흐르는 곳이라면
        q.append((0, k))
        visited[0][k] = True # 방문처리

bfs()

