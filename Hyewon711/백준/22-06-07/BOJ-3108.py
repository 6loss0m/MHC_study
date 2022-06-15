# BOJ 3108 - 로고
# FD x: 거북이를 x만큼 앞으로 전진
# LT a: 거북이를 반시계 방향으로 a도 만큼 회전
# RT a: 거북이를 시계 방향으로 a도 만큼 회전
# PU: 연필을 올린다
# PD: 연필을 내린다.

from collections import deque
import sys

input = sys.stdin.readline
dx = [1, -1, 0, 0] # 좌우
dy = [0, 0, 1, -1] # 상하


def bfs(x, y):
    q.append([x, y]) # q에 x, y값 추가
    c[x][y] = 1 # 방문 처리
    while q: # 큐가 빌 때까지 반복
        x, y = q.popleft() # x, y 값을 q의 첫번째 노드 대입
        for i in range(4): # 상하좌우를 비교한다.
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx <= 2000 and 0 <= ny <= 2000: # 현재 좌표가 0~2000사이인 경우에만
                if a[nx][ny] == 1 and c[nx][ny] == 0: # 지도에 아직 그리지않은 직사각형
                    c[nx][ny] = 1 # 방문표시
                    q.append([nx, ny]) # q에 현재 x, y좌표값 추가


n = int(input()) # 입력) 직사각형 개수 n
a = [[0]*2001 for _ in range(2001)] # 지도
c = [[0]*2001 for _ in range(2001)] # 직사각형 그리기
start = []

for _ in range(n):
    x1, y1, x2, y2 = map(int, input().split())
    # (x1, y1)는 직사각형의 한 꼭짓점 좌표이고, (x2, y2)는 그 점의 대각선 방향의 반대 꼭짓점의 좌표이다.
    x1 += 500; y1 += 500; x2 += 500; y2 += 500 # 음수 좌표 -500~ 을 양수로 판단해야하므로 + 500
    x1 *= 2; y1 *= 2; x2 *= 2; y2 *= 2 # 그래프의 크기를 *2 해주어 상하좌우 비교를 해야함, bfs는 좌표 1개씩 이동하므로
    start.append([x1, y1]) # 시작점 x1, y1을 start에 추가
    for i in range(x1, x2+1): # 가로 길이만큼 반복
        if i == x1 or i == x2: # 꼭짓점인 경우, 세로좌표 확인
            for j in range(y1, y2+1): # 세로 길이만큼 반복
                a[i][j] = 1 # 사각형의 변을 1로표시
        else:
            a[i][y1] = 1 # 사각형의 변을 1로표시
            a[i][y2] = 1 # 사각형의 변을 1로표시

q = deque()
ans = 0
for i in range(len(start)):
    x, y = start[i] # x1, y1 좌표가 저장된 start 리스트를 bfs 시작 좌표로 사용
    if c[x][y] == 0: # 방문하지 않은 좌표라면
        bfs(x, y) # bfs 실행
        ans += 1 # bfs를 빠져나온 경우 == 직사각형 그린 경우 ans +1

# N개의 직사각형을 그리는데 필요한 PU명령의 최솟값을 출력한다 == bfs에 들어가는 횟수를 카운트하고, 출력

if a[1000][1000] == 1: # 연필을 내린 상태로 시작하기 때문에 만일 입력에 원점이 존재할 경우 ans에 1을 뺀 후 출력
    ans -= 1
print(ans)