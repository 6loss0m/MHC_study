# bfs 특 queue 사용하기
# deque 모듈 안쓰면 시간복잡도 박살남(pop(0)이 시간복잡도가 O(n)이고 popleft()가 O(1)이라고 함)
from collections import deque

m, n = map(int, input().split())
# 토마토 받아서 넣기. 이차원 리스트로 만들어질거.
matrix = [list(map(int, input().split())) for _ in range(n)]
# 좌표를 넣을거니까 []를 넣자.
queue = deque([])
# 방향 리스트. [dx[0], dy[0]]은 곧 [-1, 0]이고 이는 왼쪽으로 이동하는 위치이다.
# 그려보면 이해하기 편함
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
# 정답이 담길 변수
res = 0

# queue에 처음에 받은 토마토의 위치 좌표를 append 시킨다
# n과 m을 사용하는걸 헷갈리지 말아야 함!
for i in range(n):
    for j in range(m):
        if matrix[i][j] == 1:
            queue.append([i, j])

# bfs 함수. 한번 들어가면 다 돌고 나오니까 재귀 할 필요 없음
def bfs():
    while queue:
        # 처음 토마토 좌표 x, y에 꺼내고
        x, y = queue.popleft()
        # 처음 토마토 사분면의 익힐 토마토들을 찾아본다.
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            # 해당 좌표가 좌표 크기를 넘어가면 안되고, 그 좌표에 토마토가 익지 않은채로 있어야 함(0).
            if 0 <= nx < n and 0 <= ny < m and matrix[nx][ny] == 0:
                # 익히고 1을 더해주면서 횟수를 세어주기
                # 여기서 나온 제일 큰 값이 정답이 될 것임
                matrix[nx][ny] = matrix[x][y] + 1
                queue.append([nx, ny])

bfs()
for i in matrix:
    for j in i:
        # 다 찾아봤는데 토마토를 익히지 못했다면 -1 출력
        if j == 0:
            print(-1)
            exit(0)
    # 다 익혔다면 최댓값이 정답
    res = max(res, max(i))
# 처음 시작을 1로 표현했으니 1을 빼준다.
print(res - 1)