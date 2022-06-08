# BOJ 1697 - 숨바꼭질

from collections import deque

def bfs():
    q = deque()
    q.append(n)
    while q:
        x = q.popleft() # queue의 맨 왼쪽 요소를 뽑아서 x에 저장
        if x == k : # 동생의 위치와 동일한 경우 print
            print(dist[x])
            break
        for nx in ( x-1, x+1, x*2 ) :
            # x*2, x-1, x+1 순서인 경우 0 1 일때 잘못된 값이 먼저 저장되므로 순서를 지켜서 넣기
            if 0 <=nx <= MAX and not dist[nx]: # 범위 체크 필수
                dist[nx] = dist[x] + 1 # 기존 배열의 값에 1을 더해서 하나의 움직임이 더해서 방문했다는 것을 표시
                q.append(nx) #

MAX = 10 ** 5 # 100,000
dist = [0] * 10 ** 5 # 최대값 내의 숫자만큼(100001개) 배열 dist 생성
n, k = map(int, input().split()) # 수빈이 위치 n, 동생 위치 k

bfs()