# BOJ 1167 - 트리의 지름


import sys
sys.setrecursionlimit(10 ** 6)

# dfs 탐색
def dfs(x, y):
    # 각 노드와 연결된 노드를 확인
    for a, b in graph[x]:
        # 탐색하지 않은 노드라면
        if visited[a] == -1:
            visited[a] = b + y # 탐색하기까지 걸린 간선의 거리로 초기화
            dfs(a, b + y) # 재귀


v = int(sys.stdin.readline())

# 각 노드의 연결된 정보를 트리로 표현
graph = [[] for _ in range(v + 1)]
for _ in range(v):
    w = list(map(int, sys.stdin.readline().split()))
    for j in range(1, len(w) - 2, 2):
        graph[w[0]].append([w[j], w[j + 1]])


visited = [-1] * (v + 1) # 탐색 여부, 간선의 거리
visited[1] = 0
dfs(1, 0) # 1번 노드에서 dfs 탐색

start = visited.index(max(visited)) # 1번 노드에서 제일 먼 노드를 찾는다.
visited = [-1] * (v + 1)
visited[start] = 0
dfs(start, 0) # 1번 노드부터 가장 먼 노드에서 다시 제일 먼 노드를 찾는다.

# 트리의 지름 출력
print(max(visited))