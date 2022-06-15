# 스타트링크
# F : 건물의 층
# S : 현재 층
# G : 목표 층
# U : 한번에 올라갈 수 있는 층수
# D : 한번에 내려갈 수 있는 층수
# visited :
# count :
import sys
from collections import deque

def bfs(v):
    q = deque([v]) # 현재 층 추가
    visited[v] = 1 # 방문 표시
    while q:
        v = q.popleft() # 큐에서 뽑아내 저장
        if v == G: # 목적지에 도착했다면 return
            return count[G] # 현재층까지 몇회를 움직였는지 출력
        for i in (v+U, v-D): #U만큼 위로 or D만큼 아래로
            if 0 < i <= F and not visited[i]: # 전체층보다 낮고, 방문하지 않은곳이라면
                visited[i] = 1 # 방문 표시
                count[i] = count[v] + 1 # 현재 층 방문 표시
                q.append(i) # 현재층 추가
    if count[G] == 0: # 현재층에 도달 할 수 없다면
        return "use the stairs"

input = sys.stdin.readline
F, S, G, U, D = map(int, input().split())
visited = [0 for i in range(F+1)]
count = [0 for i in range(F+1)] # 각층의 도착 횟수
print(bfs(S))