"""
    2615 - 오목
    0은 알이 놓이지 않은 자리, 1은 검은 바둑알, 2는 흰 바둑알
    검은색이 이긴 경우 = 1, 흰색이 이긴 경우 = 2, 아직 승부가 결정되지 않은 경우 = 0
    5알이 연속적으로 놓인 경우에는 이긴 것 이지만 여섯 알 이상 놓이면 이긴 것이 아니라 한다.
"""

gobang = []
result = []
for _ in range(19) : # 19 * 19
    gobang.append(list(map(int, input().split())))

dx = [1, 1, 0, -1]
dy = [0, 1, 1, 1]

def solution():
    for k in range(len(gobang)): # 행 (가로)
        for h in range(len(gobang[k])): # 열(세로)

            if gobang[k][h] != 0: # 돌이 놓여져 있다면?
                x, y = k, h  # 현재 좌표를 저장

                for i in range(4): # 놓여있는 돌의 위치 기준으로 다른 돌이 있는지 확인
                    nx = x + dx[i]
                    ny = y + dy[i]

                    if nx < 0 or nx >= len(gobang) or ny < 0 or ny >= len(gobang): # 돌이 없거나, 막다른 길인 경우에는
                        continue # continue 처리

                    startx, starty = x, y
                    count = 1
                    old_x, old_y = x, y  # 기존 x,y 값을 좌표계산을 위해 저장해놓는다.

                    while True:  # 좌표를 이동한 상태에서 만약 같은 방향으로 같은 색 바둑이 있으면 개수를 세면서 이동
                        # 만약 다음 바둑이 현 바둑 색하고 똑같다면?
                        if gobang[old_x][old_y] == gobang[nx][ny]:
                            count += 1  # 개수 1개 추가
                        else:  # 만약 색이 다르다면 반복문을 돌필요가 없기 때문에 반복문 탈출
                            break

                        # 만약 바둑 개수가 5개라면
                        if count == 5: # 5목 조건 달성
                            if len(gobang) > nx + dx[i] >= 0 and len(gobang) > ny + dy[i] >= 0: # 가로 세로 모두 바둑판 내에 있는가?
                                if gobang[nx][ny] == gobang[nx + dx[i]][ny + dy[i]]:  # 만약 다음 좌표에도 현 바둑 색이 똑같다면
                                    break # 6목이므로 break

                            if 0 <= startx - dx[i] < len(gobang) and len(gobang) > starty - dy[i] >= 0:
                                if gobang[startx][starty] == gobang[startx - dx[i]][starty - dy[i]]: #처음 돌을 둔 위치와 연결되는 위치에 돌이 있는지 확인
                                    break # 6목이므로 break

                            return [startx + 1, starty + 1, gobang[startx][starty]] # 바둑판 내에 있고 연결되는 돌이 없다면 (6목이 아니라면)

                        old_x, old_y = nx, ny  # 현재 좌표를 다음 이동 좌표로 저장
                        nx, ny = old_x + dx[i], old_y + dy[i]  # 다음 이동 좌표를 그 다음 다음 이동 좌표로 저장

                        # 만약 새로운 좌표가 범위를 벗어난다면 더이상 반복문을 돌 필요가 없으므로 break
                        if nx >= len(gobang) or ny >= len(gobang) or nx < 0 or ny < 0:
                            break

result = solution()

if result is None: # return 값이 없음 == 아직 승부가 나지 않은 경우
    print(0)
else:
    print(result[2]) # 승부 결과
    print(result[0], result[1]) # 연속 바둑알 중 가장 왼쪽 또는 가장 위에 있는 바둑알의 가로줄, 세로줄 번호