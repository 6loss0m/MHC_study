# 문자판
# N개의 줄에는 M개의 알파벳대문자, 상하좌우 K만큼 동가능
# 왼, 아래, 오, 위
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def dfs(x, y, idx):
    if idx >= len(target):  # 왜 이게 먼저 와야 되는 걸까???? 그 이유를 알아야함!
        return 1            # 순회하기 전에 체크를 먼저해야 indexerror가 발생 x
    # index는 단어의 길이만큼만 선언되었기 때문에 그보다 크면 indexerror
    # 해당 문자열이 target이 아니라면 재귀로 올수도 없었기 때문에 무조건 조건 달성
    if dp[x][y][idx] != -1: # 방문했다면
        return dp[x][y][idx]  # 리턴만 해줘도 됨

    dp[x][y][idx] = 0  # 방문 표시 겸 결과 값
    for i in range(4): # 상하좌우 4방향
        tmp_x, tmp_y = x, y
        # k는 이동 한도 범위를 나타냄
        for _ in range(k):
            nx = tmp_x + dx[i]
            ny = tmp_y + dy[i]

            if 0 <= nx < n and 0 <= ny < m: # 이동가능한 범위라면
                if matrix[nx][ny] == target[idx]: # 문자열이 일치할경우 (단어완성가능)
                    dp[x][y][idx] += dfs(nx, ny, idx + 1)
            tmp_x, tmp_y = nx, ny  # k가 2 이상일 때 사용하기 위해
    return dp[x][y][idx] # 0 반환


n, m, k = map(int, input().split())

# print(matrix)
matrix = []
for _ in range(n):
    matrix.append(list(input()))
# print(matrix)
target = list(input())
# print(target)
start = []
# 첫 문자가 같은걸 모조리 찾아서 시작하기 위해 우선 찾는것!
for i in range(n):
    for j in range(m):
        if matrix[i][j] == target[0]:
            start.append([i, j])
# memset(dp, -1, sizeof(dp)) 을 멀로 대채해야 할까?
dp = [[[-1] * len(target) for _ in range(m)] for _ in range(n)] # 3겹 리스트
#print(dp)
# M,N = 4, K = 1
# 단어 : BREAK
# [
#   [
#       [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1]
#   ],
#   [
#       [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1]
#   ],
#   [
#       [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1]
#   ],
#   [
#       [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1]
#   ]
# ]
res = 0
for i in range(len(start)):
    x, y = start[i]
    res += dfs(x, y, 1)
print(res)

# https://goodsosbva.tistory.com/67