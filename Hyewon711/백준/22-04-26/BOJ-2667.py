# BOJ 2667 - 단지번호붙이기
# 문제를 보니, 이것도 BFS DFS 문제처럼 상하좌우를 비교하는 문제같다고 추측

n = int(input()) # 지도의 크기
graph = [] # 그래프
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
ans = []

for i in range(n): # 단지 그리기
    graph.append(list(map(int, input()))) # 입력받은 줄로 그래프 그리기

def dfs(x, y): # 깊이우선탐색
    global cnt # cnt 선언
    graph[x][y] = False # 방문표시 = 0
    cnt += 1 # 탐색할 때 마다 cnt +1
    for i in range(4) : # 4방향 비교
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1: #인접한 곳의 좌표가 범위 내이고, == 1 이라면
            graph[nx][ny] = False #방문한 곳으로 처리
            dfs(nx, ny) #조건을 만족하는 지점에서 다시 탐색을 시작
    return cnt # cnt를 리턴해준다.

for i in range(n) :
    for j in range(n):
        if graph[i][j] == 1: # 집이 있는 경우
            cnt = 0 # cnt 0으로 초기화
            ans.append(dfs(i, j)) # dfs를 통해 단지를 확인하자. return 받은 cnt 값을 ans에 추가.

print(len(ans)) # 첫째 줄은 총 단지수
ans.sort() # 오름차순으로 정렬
for i in ans:
    print(i) # ans에 저장된 값을 출력한다.
