"""
16956 - 늑대와 양

울타리를 어떻게 설치해도 늑대가 양이 있는 칸으로 갈 수 있다면 첫째 줄에 0을 출력한다.
즉, 늑대의 4방향에 양이 있다면 바로 break, 0을 출력하면 된다.
늑대가 양이 있는 칸으로 갈 수 없다면 1을 출력하고 목장의 상태를 출력한다.
즉, 양S의 4방향에 늑대W가 없어야한다.

주의 : 이 문제는 설치해야하는 울타리의 최소 개수를 구하는 문제가 아님.
따라서 .를 D로 바꿔버리고, 늑대를 기준으로 4방향을 탐색
"""

import sys

input = sys.stdin.readline

r, c = map(int, input().split()) # 목장의 크기 R x C
state = [] # 목장의 상태
check = False

for _ in range (r) :
    state.append(list(input().rstrip()))

for i in range(r): # 가로줄
    for j in range(c): # 세로줄
        if state[i][j] == "W" : # 1) 만약 현재 위치에 늑대가 있다면
            dx = [-1, 1, 0, 0] # 좌우
            dy = [0, 0, -1, 1] # 상하
            for k in range(4) : # 좌표를 확인한다.
                nx, ny = i+dx[k], j+dy[k]
                if nx < 0 or nx >= r or ny < 0 or ny >= c : # 만약 목장을 벗어난 경우 continue
                    continue
                if state[nx][ny] == "S" : # 다음 좌표에 양이 있다면?
                    check = True # 늑대 4방향에 양이 있으므로 추후 0을 출력할 것
                    break # 더이상 for문을 실행할 필요가 없다.
        elif state[i][j] == "S" : # 2) 만약 현재 위치에 양이 있다면
            continue
        elif state[i][j] == "." : # 3) 만약 현재 위치에 길이 있다면
            state[i][j] = "D" # D로 변경

if check :
    print(0)
else :
    print(1)
    for i in state:
        print(''.join(i)) # 이어서 출력


