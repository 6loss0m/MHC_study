# BOJ 2146 - 다리 만들기
# https://konghana01.tistory.com/181?category=954769
# 0. 지도를 입력받을 때 각 섬의 번호를 음수로 붙여 해당 섬의 육지는 해당 섬의 번호를 값으로 갖도록 한다.
# 1. 각 섬의 번호를 key로 하고 해당 섬의 육지와 바다가 인접한 지역을 value로 가지는 딕셔너리를 만든다.
# 2. 각 섬을 탐색할 때마다 지도를 복사를 한 뒤, 각각의 위치에서 BFS를 탐색하고, 지도에서 이동할 위치보다 움직인 횟수가 작다면 이를 큐에 삽입하고, 그렇지 않다면 패스한다.
# 3. 위의 과정을 반복하며 다른 섬에 도달했을 때 그 시간을 저장한 뒤, 모든 섬을 탐색한 뒤, 최소 시간을 출력한다.
from collections import deque

def labeling_island():
    num = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                num -= 1
                queue = deque([])
                queue.append([i, j])
                board[i][j] = num
                island[num] = []
                while queue:
                    r, c = queue.popleft()
                    check = False
                    for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        if 0<=r+dr<=n-1 and 0<=c+dc<=n-1:
                            if board[r+dr][c+dc] == 1:
                                board[r+dr][c+dc] = num
                                queue.append([r+dr, c+dc])
                            elif not board[r+dr][c+dc]:
                                check = True
                    if check:
                        island[num].append([r, c])

def calc_distance(i, j, num):
    global dist
    queue = deque([])
    queue.append([i, j])
    board_[i][j] = 0
    while queue:
        r, c = queue.popleft()
        for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            if 0<=r+dr<=n-1 and 0<=c+dc<=n-1:
                if 0 == board_[r+dr][c+dc] or board_[r][c] + 1 < board_[r+dr][c+dc]:
                    queue.append([r+dr, c+dc])
                    board_[r+dr][c+dc] = board_[r][c] + 1

                elif board_[r+dr][c+dc] < 0 and board_[r+dr][c+dc] != num:
                    board_[i][j] = num
                    dist = min(board_[r][c], dist)
                    return
    board_[i][j] = num

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
island = {}
labeling_island()

dist = 10000
for num, array in island.items():
    board_ = [x[:] for x in board]
    for i, j in array:
        calc_distance(i, j, num)

print(dist)