# BOJ 1967 - 트리의 지름
# 임의의 노드에서 각 노드까지의 거리를 측정하여 최대 거리를 가지는 노드는 트리의 지름을 이루는 한 노드이다.
# 임의의 한 점에서 DFS, BFS 등으로 각 노드까지의 거리를 구한 후, 이 중 최대 거리를 갖는 노드에서 시작하여
# 다시 한 번 각 노드까지의 최대 거리를 구하면 그 최대 거리가 트리의 지름이 된다.
# 출처 : https://blog.myungwoo.kr/112

import sys
sys.setrecursionlimit(10 ** 9)

# dfs 탐색
def dfs(x, y): # 시작 노드 번호, 현재 노드 가중치

    # 반복문을 통해 현재 노드와 연결된 노드, 연결된 노드의 가중치를 확인한다.
    for a, b in graph[x]:

        # 탐색하지 않은 노드라면 탐색한다.
        if visited[a] == -1:
            visited[a] = y + b # 이전 노드의 가중치와 현재 노드의 가중치를 더한다.
            dfs(a, y + b) # 재귀적으로 연결된 모든 노드를 탐색

n = int(sys.stdin.readline())

# 각 노드가 연결된 정보를 트리로 표현
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

visited = [-1] * (n + 1) # 탐색 확인, 가중치 확인
visited[1] = 0 # 시작 노드는 가중치를 0으로 초기화
dfs(1, 0) # 첫 번재 노드를 dfs 탐색
# 루트 노드의 번호는 항상 1이라고 가정하며, 간선의 가중치는 100보다 크지 않은 양의 정수이다.
# 위에서 찾은 노드에 대한 가장 먼 노드를 찾는다.
start = visited.index(max(visited))

visited = [-1] * (n + 1) # 탐색 확인, 가중치 확인
visited[start] = 0 # 가장 먼 노드의 가중치를 0으로 초기화
dfs(start, 0) # 가장 먼 노드를 dfs 탐색

# 트리의 지름 출력
print(max(visited))