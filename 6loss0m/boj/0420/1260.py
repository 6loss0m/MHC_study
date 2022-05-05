# DFS와 BFS
# 개념 https://bmy1320.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1-DFS-BFS

import sys
from collections import deque

def dfs (n):
    visited[n] = True
    print(n,end=' ')
    for i in graph[n]:
        if not visited[i]:
            dfs(i)
def bfs(n):
    queue = deque([n])
    visited[n] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
n,m,v = map(int,sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(1,n+1):
    graph[i].sort()

visited = [False] * (n+1)
dfs(v)
print()
visited = [False] * (n+1)
bfs(v)

# 참고 : https://bmy1320.tistory.com/m/entry/%EB%B0%B1%EC%A4%80-class3-%EB%AC%B8%EC%A0%9C-%EB%B0%B1%EC%A4%80-%ED%8C%8C%EC%9D%B4%EC%8D%AC-1260-DFS%EC%99%80-BFS