# BOJ 1261 - 알고스팟
# 문제는 길게 설명되어있지만 사실상 미로찾기와 동일하다.
# 가중치가 0 또는 1인 그래프

from collections import deque
dx = [-1,1,0,0]
dy = [0,0,-1,1]
# 상하 좌우 탐색

m, n = map(int, input().split()) # 가로 * 세로
arr = [ list(map(int, input())) for _ in range(n)] # 미로의 상태
dist = [[-1] * m for _ in range(n)]  # 방문 확인

q = deque()
q.append((0,0))
dist[0][0] = 0

# 방과 방 사이를 이동하는데 부숴야하는 벽의 수를 노드 간 이동 비용이라 한다.

while q: # bfs 탐색
    x, y = q.popleft() # 큐에서 하나의 원소를 뽑아 x, y에 대입
    for k in range(4): # 현재 위치에서 4가지 방향으로의 위치 확인
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < n and 0 <= ny < m: # 벗어나지 않은 경우
            if dist[nx][ny] == -1: # 방문하지 않은 경우
                if arr[nx][ny] == 0: # arr의 해당 위치의 비용이 0인 경우라면 앞에 추가
                    dist[nx][ny] = dist[x][y] # 그대로 대입 ( 벽을 부수지 않음)
                    q.appendleft((nx, ny)) # 앞에 추가
                else: # 비용이 1인 경우라면 뒤에 추가
                    dist[nx][ny] = dist[x][y] + 1 # 직전 노드+1
                    q.append((nx, ny)) # 뒤에 추가

# 위의 반복문이 돌면 bfs 를 돌면서 우선순위인 0은 앞쪽에, 1은 뒷쪽에 놓인다.
# 가장 오른쪽 아래까지의 최단 거리 반환
print(dist[n-1][m-1])

# for i in dist :
#     for j in i:
#         print(j, end=" ")
#     print()