# 알파벳

r, c = map(int, input().split())
maps = []
for _ in range(r):
    maps.append(list(input()))
ans = 0
alphas = set()
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, count):
    global ans
    ans = max(ans, count)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < r and 0 <= ny < c and not maps[nx][ny] in alphas:
            alphas.add(maps[nx][ny])
            dfs(nx, ny, count+1)
            alphas.remove(maps[nx][ny])
alphas.add(maps[0][0])
dfs(0, 0, 1)
print(ans)

# https://devjin-blog.com/boj-1987-alphabet/