# 2606 - 바이러스
"""
    문제를 보자마자 많이 본 유형이라 생각되었다.
    연결된 컴퓨터 쌍의 노드를 그래프로 이어주고, bfs나 dfs로 탐색 후
    이전 방문 노드와 연결이 되어있다면 방문하고 카운트해주는 방법으로 문제를 풀 수 있을 것 같다.
"""
from collections import deque

n = int(input()) # 컴퓨터의 수 (범위는 100 이하)
m = int(input()) # 연결되어있는 컴퓨터 쌍의 수
graph = [ [] for _ in range(n+1) ]
visited = [False] * (n+1) # 방문 정보 확인용
cnt = 0

def bfs(graph, v):
    global cnt
    queue = deque([v])
    while queue : # 큐가 빌 때까지 반복
        v = queue.popleft()
        visited[v] = True # 현재 노드 방문처리
        for i in graph[v]:
            if not visited[i]: # 아직 방문하지 않았다면
                visited[i] = True # 방문처리
                queue.append(i) # queue에 현재 비교하고 있는 쌍 추가
                cnt +=1 # 연결되어 있으므로 +1

for _ in range(m) : # 연결된 컴퓨터 쌍을 그래프의 연결 요소로 append.
    num1, num2 = map(int, input().split())
    graph[num1].append(num2)
    graph[num2].append(num1)

for v in range(1, n+1):
    if visited[v]: continue # 만약 true라면 continue
    bfs(graph, 1) # 1번 노드부터 시작, bfs

print(cnt)