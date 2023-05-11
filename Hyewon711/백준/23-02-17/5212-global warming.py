"""
    5212 - 지구 온난화
    R*C 크기의 2차원 배열, X는 땅 .은 바다
    50년 후에는 인접한 3칸 or 4칸에 바다가 있는 땅은 모두 잠긴다.
    50년 후의 지도는 모든 섬을 포함하는 가장 작은 직사각형이며 적어도 섬 1개는 남아있다.
    지도 범위를 벗어나는 칸은 모두 바다이다.

    X를 기준으로 4방향 탐색하면 될 것 같음
"""

r, c = map(int, input().split())

graph = [[0] * c for _ in range(r)]
copy = [[0] * c for _ in range(r)]

dx = [0, 0, -1, 1] # 4방향 탐색용
dy = [-1, 1, 0, 0] # 4방향 탐색용

for i in range(r): # 지도 그리기 (1: 땅 0: 바다)
    j = 0
    for s in input():
        if s == "X":
            graph[i][j] = 1
        j += 1

for i in range(r): # 지도 copy
    for j in range(c):
        copy[i][j] = graph[i][j]

for i in range(r): # 1을 기준으로 4방향 탐색
    for j in range(c):
        if graph[i][j] == 1:
            cnt = 0
            for n in range(4):
                ax = i + dx[n]
                ay = j + dy[n]
                if r <= ax or ax < 0 or c <= ay or ay < 0:
                    cnt += 1
                else:
                    if graph[ax][ay] == 0:
                        cnt += 1
            if cnt > 2:
                copy[i][j] = 0

# 출력
row = []
col = []
dic = {0: ".", 1: "X"}

for i in range(r):
    for j in range(c):
        if copy[i][j] == 1:
            row.append(i)
            col.append(j)

if row:
    row_l = min(row)
    row_h = max(row)
    col_l = min(col)
    col_h = max(col)

    for i in range(row_l, row_h + 1):
        for j in range(col_l, col_h + 1):
            print(dic[copy[i][j]], end="")
        print()

else:
    print('X')