"""
12761 - 돌다리

1) 좌우로 1만큼 이동하거나 (2가지)
2) 스카이 콩콩으로 A, B만큼 좌우로 +- 이동 (4가지)
3) 스카이 콩콩으로 힘을모아 A, B만큼 * 오른쪽 이동 (2가지)

A, B배 만큼 왼쪽으로 가는 경우는 생각하지 않는다.
(왼쪽으로 A, B만큼 힘을모아 뛰어가는 가능 경우는 1~2) 연산보다 항상 크기때문)

A,B는 2이상 30이하
N,M은 0이상 10만이하

"""
from collections import deque

a, b, n, m = map(int, input().split()) # 스카이 콩콩 힘 a, b, 동규 현재위치 n,  주미 현재위치 m
bridge = [0]*100001 # n, m의 최대값 10만
visited = [0]*100001 # 방문 체크
q = deque()

# 건너는 방법
dx = [-1, 1, -a, a, -b, b, a, b]

def bfs(start):
    q.append(start)
    visited[start] = 1 # 방문처리
    while q :
        x = q[0] #
        del q[0]

        for i in range(8) : # 8가지 방법으로 확인
            if i < 6 :
                nx = x + dx[i] # 좌우로 +- 이동하는 6가지 경우
                if 0 <= nx < 100001 and visited[nx]==0 : # 아직 방문하지 않았고 0~10만 사이인 경우
                    q.append(nx)
                    visited[nx] = 1 #방문처리
                    bridge[nx] = bridge[x]+1 # 주미한테 가는 방법을 count +1
            else : # 힘을모아 점프하는 2가지 경우
                nx = x * dx[i]
                if 0 <= nx < 100001 and visited[nx]==0 : # 아직 방문하지 않았고 0~10만 사이인 경우
                    q.append(nx)
                    visited[nx] = 1 #방문처리
                    bridge[nx] = bridge[x]+1 # 주미한테 가는 방법을 count +1


bfs(n) # 동규의 위치 n에서부터 bfs 탐색
print(bridge[m]) # 주미의 위치에는 갈 수 있는 경로의 수가 cnt 되어있다.
