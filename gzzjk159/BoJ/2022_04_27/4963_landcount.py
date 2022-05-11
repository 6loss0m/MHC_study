import sys

read = sys.stdin.readline
sys.setrecursionlimit(10000)


def dfs(x, y):
    dx = [1, 1, -1, -1, 1, -1, 0, 0]
    dy = [0, 1, 0, 1, -1, -1, 1, -1]

    field[x][y] = 0
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < h and 0 <= ny < w and field[nx][ny] == 1:
            dfs(nx, ny)


while True:
    w, h = map(int, read().split())
    if w == 0 and h == 0:
        break
    field = []
    count = 0
    for _ in range(h):
        field.append(list(map(int, read().split())))
    for i in range(h):
        for j in range(w):
            if field[i][j] == 1:
                dfs(i, j)
                count += 1

    print(count)