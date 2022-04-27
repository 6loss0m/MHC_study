# BOJ 1260 - DFS와 BFS
# 깊이우선 탐색 DFS와 너비우선 탐색 BFS의 결과값 출력하기
# n = 정점의 개수 m = 간선의 개수 v = 탐색을 시작할 정점의 번호

def dfs(v): # 재귀함수 이용
    print(v, end=' ') # 번호는 사이에 공백을 주어 print
    visit[v] = 1 #방문한 노드라면 1로 변경
    for i in range(1, n+1): # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        if visit[i] == 0 and s[v][i] == 1: # 아직 방문하지 않았다면, 연결된 정점이 있다면
            dfs(i) # 모든 노드를 방문할때까지 재귀함수 돌기

def bfs(v): # 큐를 이용
    queue = [v]
    visit[v] = 0 # dfs를 먼저 실행하였기에 1로 변경되어있음, 0으로 초기화 해준다.
    while(queue):
        v = queue.pop(0) # 큐에서 노드를 꺼낸다.
        print(v, end=' ') # 번호는 사이에 공백을 주어 print
        for i in range(1, n+1): # 해당 노드의 인접 노드 중 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리를 한다.
            if visit[i] == 1 and s[v][i] == 1: # 아직 방문하지 않은경우, 연결된 정점이 있다면
                queue.append(i)
                visit[i] = 0 # dfs에서 1로 처리되어있으므로 0으로 방문처리

n, m, v = map(int, input().split())
s = [[0] * (n + 1) for i in range(n + 1)]
visit = [0 for i in range(n + 1)]

for i in range(m):
    x, y = map(int, input().split())
    s[x][y] = 1 # 인접행렬 (s[x][y] = s[y][x] = 1
    s[y][x] = 1

dfs(v)
print()
bfs(v)