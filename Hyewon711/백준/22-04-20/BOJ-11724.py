# BOJ 11724 - 연결 요소의 개수
import sys
import collections

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int,input().split()) # 정점의 개수 N과 간선의 개수 M
graph = collections.defaultdict(list) # 빈 그래프 생성
visited = [] # 방문 노드 저장

# 그래프 생성
for _ in range(M):
    u, v = map(int,input().split())
    graph[u].append(v) # M개의 줄에 간선의 양 끝점 u와 v
    graph[v].append(u) # M개의 줄에 간선의 양 끝점 v와 u

# dfs
def dfs(n):
    if n in visited:# 이미 방문한 경우 return
        return
    visited.append(n) # 방문하지 않은 노드에 대해 연결된 노드 방문 처리

    for node in graph[n]: # 모든 노드를 방문할 때 까지 재귀함수
        dfs(node)

cnt = 0 # 연결 요소 개수

for i in range(1, N+1):
    if i not in visited: # 탐색하지 않은 정점 dfs 탐색
        dfs(i)
        cnt += 1 # dfs 탐색이 마치면 연결 요소 +1

print(cnt) # 첫째 줄에 연결 요소의 개수를 출력한다.