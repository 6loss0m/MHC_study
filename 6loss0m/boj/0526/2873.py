# 롤러코스터
import sys

r, c = map(int, sys.stdin.readline().split())
ground = [list(map(int, sys.stdin.readline().split())) for _ in range(r)]
# 세로가 홀수 (3,4)
# → → → ↓
# ↓ ← ← ←
# → → → □
if r % 2 == 1:
    print(('R' * (c - 1) + 'D' + 'L' * (c - 1) + 'D') * (r // 2) + 'R' * (c - 1))
# 가로가 홀수 (4,3)
# ↓ → ↓
# ↓ ↑ ↓
# ↓ ↑ ↓
# → ↑ □
elif c % 2 == 1:
    print(('D' * (r - 1) + 'R' + 'U' * (r - 1) + 'R') * (c // 2) + 'D' * (r - 1))
elif r % 2 == 0 and c % 2 == 0:
    low = 1000
    position = [-1, -1]

    for i in range(r):
        if i % 2 == 0: # 짝수행
            for j in range(1, c, 2): # 홀수 인덱스 최소값
                if low > ground[i][j]:
                    low = ground[i][j]
                    position = [i, j]
        else:  # i % 2 == 1 (홀수행)
            for j in range(0, c, 2): # 짝수 인덱스 최소값
                if low > ground[i][j]:
                    low = ground[i][j]
                    position = [i, j]

    res = ('D' * (r - 1) + 'R' + 'U' * (r - 1) + 'R') * (position[1] // 2)
    # 홀수를 짝수로 만들어준다.
    # ex) 2 * (5 // 2) = 4
    x = 2 * (position[1] // 2)
    # y는 무조건 위에서 시작하기 때문에 0
    y = 0
    # 홀수를 짝수로 만들어준다음 무조건 오른쪽 1칸을 이동해야하는 과정이 있기 때문에
    # xbound에다가 +1 해서 넣어줌
    xbound = 2 * (position[1] // 2) + 1

    # x와 xbound가 같고, y가 맨 밑 칸까지 갔다면 멈춤
    while x != xbound or y != r - 1:
        # x가 xbound보다 왼쪽에 있고 [y, xbound]와 position의 값이 틀리다면 오른쪽 이동
        if x < xbound and [y, xbound] != position:
            x += 1
            res += 'R'
        # x가 xbound랑 값이 같으며, [y, xbound]와 position의 값이 틀리다면 왼쪽 이동
        elif x == xbound and [y, xbound - 1] != position:
            x -= 1
            res += 'L'
        # 마지막 줄이 아니라면 아래쪽으로 이동
        if y != r - 1:
            y += 1
            res += 'D'

    res += ('R' + 'U' * (r - 1) + 'R' + 'D' * (r - 1)) * ((c - position[1] - 1) // 2)

    print(res)

# https://seungyong20.tistory.com/39