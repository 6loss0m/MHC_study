"""
   1890 - 점프

"""

import sys

n = int(sys.stdin.readline()) # 게임 판의 크기
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)] # 모든 경우의 수를 저장할 변수 선언
dp[0][0] = 1 # 초기 값

for i in range(n):
    for j in range(n):
        if i == n - 1 and j == n - 1: # 끝에 도달한 경우, 결과값을 출력하고 종료
            print(dp[i][j])
            break

        # 오른쪽으로만 이동할 때
        if j+graph[i][j] < n:
            dp[i][j+graph[i][j]] += dp[i][j] # j를 graph[i][j]에 저장된 수 만큼 이동한다. (열)

        # 아래로만 이동할 때
        if i+graph[i][j] < n:
            dp[i+graph[i][j]][j] += dp[i][j] # i를 graph[i][j]에 저장된 수 만큼 이동한다. (행)