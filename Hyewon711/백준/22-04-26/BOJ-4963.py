# BOJ 4963 - 섬의 개수
# 이것도 BFS DFS 문제로 상하좌우를 확인한다.
# 조금 다른 점은 건널 수 있다면 1칸으로 치는데, 즉 8방향을 확인해야한다.

# dx = [1, 1, -1, -1, 1, -1, 0, 0]
# dy = [0, 1, 0, 1, -1, -1, 1, -1]
import sys
sys.setrecursionlimit(10000) # 재귀한도를 설정해주어야 런타임 에러 (RecursionError)가 발생하지 않음.

def dfs(x, y):
    dx = [1, 1, -1, -1, 1, -1, 0, 0]
    dy = [0, 1, 0, 1, -1, -1, 1, -1]

    graph[x][y] = 0 # 0으로 초기화 
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 1: # 현재 위치에서 인접한 곳의 좌표가 범위 내이고, == 1 이라면
            dfs(nx, ny) # 모두 돌때까지 재귀

while True:
    w, h = map(int, input().split()) # 지도의 넓이 w = 가로 h = 세로
    if w == 0 and h == 0 :
        break # 입력의 마지막줄엔 0 0 이 들어온다.
    graph = [] # 그래프 선언
    cnt = 0

    for _ in range(h): # 지도 그리기
        graph.append(list(map(int, input().split()))) # 입력받은 줄로 그래프 그리기

    for i in range(h) : # 세로의 길이 = 행
        for j in range(w): # 가로의 길이 = 열
            if graph[i][j] == 1: # 섬이 있는경우
                dfs(i, j) # dfs를 통해 단지를 확인하자.
                cnt += 1 # 그 후 cnt를 추가하여 섬의 개수 세기

    print(cnt) # 섬의 개수 출력