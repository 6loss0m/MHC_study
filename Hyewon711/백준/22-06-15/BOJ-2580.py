# BOJ 2580 - 스도쿠
# 가로, 세로 행을 비교하여 1~9까지 각 숫자가 1개씩 들어가야한다.
# 빈칸은 0으로 표기, 0에 적절한 숫자를 채워 출력하기
# dfs - 백트래킹

import sys

input = sys.stdin.readline
graph = [] # 입력받는 스도쿠판
blank = [] # 0

for i in range(9):
    graph.append(list(map(int, input().rstrip().split())))

for i in range(9): # 스도쿠판에서 공백 = 0 인 위치를 blank에 저장
    for j in range(9):
        if graph[i][j] == 0:
            blank.append((i, j))

def dfs(n):
    if n == len(blank): # 공백의 개수만큼 반복
        for i in graph:
            print(*i) # 그래프 전체 출력
        sys.exit(0)
        # 문제가 풀렸으므로 종료
        return

    row, col = blank[n]
    nums = [i for i in range(1,10)] # nums는 1부터 9까지 저장

    for i in graph[row]:  # 1) 공백이 있는 가로줄 비교
        if i in nums: # 칸이 1~9의 숫자로 채워져있다면
            nums.remove(i) # 1~9에서 제외

    for i in range(9):     # 2) 공백이 있는 세로줄 비교
        if graph[i][col] in nums: # 칸이 1~9의 숫자로 채워져있다면
            nums.remove(graph[i][col]) # nums에서 제외

    a, b = row//3, col//3
    for i in range(a*3, (a+1)*3): # 3) 스도쿠 판 안의 3*3 칸 비교
        for j in range(b*3, (b+1)*3): # 0~2, 3~5, 6~8이 같은 그룹으로 묶이므로 x,y 좌표를 3으로 나눈 몫에 3을 곱하면
            # 그룹에서 시작하는 인덱스 값을 알 수 있다.
            if graph[i][j] in nums:
                nums.remove(graph[i][j]) # nums 에서 제외

    for i in nums: # 남은 nums는 공백에 들어갈 후보 숫자들만 남은 상태
        graph[row][col] = i # 공백의 칸을 nums에 남은 숫자로 대입하고 (유망한 숫자)
        dfs(n+1) # 다음의 0으로 넘어간다.
    graph[row][col] = 0
    #초기화 (정답이 없을 경우를 대비)

dfs(0)