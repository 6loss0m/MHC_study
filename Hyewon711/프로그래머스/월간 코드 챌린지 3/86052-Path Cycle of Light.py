# 86052 - 빛의 경로 사이클
# 시계방향 혹은 반시계 방향으로
# 빛의 경로 사이클의 모든 길이들을 배열에 담아 "오름차순"으로 정렬하여 return
# https://kimjingo.tistory.com/216
#     ↓  ←   ↑  →
dy = (1, 0, -1, 0)
dx = (0, -1, 0, 1)

def solution(grid):
    answer = []

    ly, lx = len(grid), len(grid[0])

    # 4방향 방문 기록 리스트 : y*x*4
    visited = [[[False] * 4 for _ in range(lx)] for _ in range(ly)]

    # 모든 좌표에 대하여 탐색
    for y in range(ly):
        for x in range(lx):
            # (y, x) 좌표에 대해 4방향 탐색
            for d in range(4):
                # 해당 [좌표-방향] 이 기존에 사용된 경우
                if visited[y][x][d]:
                    continue

                # 사용되지 않은 [좌표-방향]인 경우
                count = 0
                ny, nx = y, x
                # 빛을 이동 시켜가며 탐색
                while not visited[ny][nx][d]:
                    visited[ny][nx][d] = True
                    count += 1
                    if grid[ny][nx] == "S": # S의 경우 방향 변경 X
                        pass
                    elif grid[ny][nx] == "L": # L의 경우 반시계방향
                        d = (d - 1) % 4
                    elif grid[ny][nx] == "R": # R의 경우 시계방향
                        d = (d + 1) % 4

                    # 좌표의 길이로 %연산을 하여 격자를 벗어난 경우에도 자리를 찾아가도록함.
                    ny = (ny + dy[d]) % ly
                    nx = (nx + dx[d]) % lx

                answer.append(count)
    answer = sorted(answer) # 오름차순 정렬
    return answer
