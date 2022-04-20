# 연결 요소의 개수
import sys

# 재귀 제한 풀기
sys.setrecursionlimit(10000)

N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]
graph[0] = [0,0]
visited = [False for _ in range(N+1)]

count = 0

for _ in range(M):
    start, end = map(int, sys.stdin.readline().split())
    graph[start].append(end)
    graph[end].append(start)
    graph[start].sort()
    graph[end].sort()


def DFS(graph, start, visited):
    visited[start] = True

    for i in graph[start]:
        if not visited[i]:
            DFS(graph, i, visited)


for i in range(1, len(visited)):
    if visited[i] == False:
        count += 1
        DFS(graph, i, visited)

print(count)