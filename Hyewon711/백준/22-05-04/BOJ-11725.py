# BOJ 11725 - 노드의 부모찾기
# BFS나 DFS를 통해 모든 노드를 방문해주고, 직전 부모노드를 출력해준다.

import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n = int(input()) # 노드의 개수
graph = [[] for _ in range(n+1)] # 그래프 그리기
visited = [ False for _ in range(n+1)] # n+1 크기만큼 배열을 False로 초기화
answer = [0] * (n+1) # n+1 크기만큼 배열을 0으로 초기화

for _ in range(n-1):
    o, t = map(int, input().split()) # 트리 상에서 연결된 두 정점
    graph[o].append(t) # 양방향으로 두 정점(노드)을 연결한다.
    graph[t].append(o)

def dfs(node):
    visited[node] = True
    for i in graph[node]:
        if not visited[i]: # 만약 visited[i]가 False 라면 (방문되지 않았다면)
            answer[i] = node
            dfs(i) # 재귀
    return

dfs(1) # 루트는 1 이므로 1부터 시작

for i in range(2, len(answer)): #
    print(answer[i])