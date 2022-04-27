# BOJ 7576 - 틈매러
# 대각선은 영향을 주지않고 상하좌우 인접해 있는 토마토만 영향을 받는다.
# 최소 일수를 구하는 프로그램이므로 BFS
# 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸

from collections import deque
m,n = map(int,input().split()) # 상자의 크기를 나타내는 두 정수 M(가로),N(세로)
graph = [] # 그래프
queue = deque([])
ans = 0 # 최소 일수를 저장할 변수

dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(n):
    graph.append(list(map(int,input().split()))) #둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보

    for j in range(m): # 익은 토마토는 1로 표기한다.
        if graph[i][j]==1:
            queue.append([i,j])

def bfs(): # bfs 함수
    while queue: # 큐가 빌때까지 반복
        x,y = queue.popleft() # 선입선출

        for i in range(4):
            a = x+dx[i]
            b = y+dy[i]
            if 0 <= a < n and 0 <= b < m and graph[a][b]==0: # 상하좌우를 비교하면서 막다른 길이 있지않고 익은 토마토가 있는 경우
                queue.append([a,b])
                graph[a][b] = graph[x][y]+1
bfs()

for i in graph:
    for j in i:
        if j==0: # 모두 찾아봤을 때, 0이 나오면 토마토가 없는 것이므로 -1을 출력한다.
            print("-1")
            exit(0)
    ans = max(ans, max(i)) # 토마토가 다 익었을 때(1) 최대값을 통해 최소 일수를 알 수 있다.
print(ans-1) # 최초 1이 한번 더 카운트되므로 -1
