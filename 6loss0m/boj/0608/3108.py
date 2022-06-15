# 로고
from collections import deque
import sys

input = sys.stdin.readline
dx = [1, -1, 0, 0] # 좌우
dy = [0, 0, 1, -1] # 상하

def bfs(x, y):
    q.append([x, y])
    c[x][y] = 1 # 방문 표시
    while q:
        x, y = q.popleft()
        for i in range(4): # 상하좌우 ,PU의 개수만 세기 때문에 다른 명령은 무시
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx <= 2000 and 0 <= ny <= 2000: # 지도내부에서 이동가능하다면
                if a[nx][ny] == 1 and c[nx][ny] == 0: # 지도가 직사각형의 내부 and 방문하지 않은 곳
                    c[nx][ny] = 1 # 방문 체크
                    q.append([nx, ny]) # 위치 추가
    # 더이상 방문할 수 있는 곳이 없다면 bfs 종료 --> PU 명령어


n = int(input())
a = [[0]*2001 for _ in range(2001)] # 지도가 되는 리스트
c = [[0]*2001 for _ in range(2001)] # 방문 표시
start = []
for _ in range(n):
    x1, y1, x2, y2 = map(int, input().split())
    # 한칸에 겹쳐있는 사각형을 구분하기위해서
    # 예) (3,3)에 겹쳐있는경우 (3,3) (3,4) 등으로 떼어내기 위해서서    x1 += 500; y1 += 500; x2 += 500; y2 += 500
    x1 *= 2; y1 *= 2; x2 *= 2; y2 *= 2
    start.append([x1, y1])
    for i in range(x1, x2+1):
        if i == x1 or i == x2:
            for j in range(y1, y2+1):
                a[i][j] = 1 # 직사각형내부를 1로 채움
        else: # 위아래 테두리 1로 변경
            a[i][y1] = 1
            a[i][y2] = 1

q = deque()
ans = 0
for i in range(len(start)):
    x, y = start[i]
    if c[x][y] == 0: # 방문하지 않았다면
        bfs(x, y)
        ans += 1

if a[1000][1000] == 1:
    ans -= 1
print(ans)