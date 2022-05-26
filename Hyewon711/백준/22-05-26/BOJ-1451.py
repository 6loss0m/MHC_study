# BOJ 1451 - 직사각형으로 나누기
n, m = map(int, input().split())

# 입력받은 전체 직사각형을 저장하기 위한 리스트(편리한 인덱싱을 위해 행 삽입)
retangle = [[0 for _ in range(m + 1)]]


for _ in range(n):
    # 라인별로 읽고 rectangle에 저장(편리한 인덱싱을 위해 [0] 삽입)
    lineInput = [0] + list(map(int, list(input())))
    retangle.append(lineInput)

# print(retangle)

# 답은 최댓값을 출력해야 하므로, 0으로 시작
res = 0

# 합을 저장할 리스트
sum = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

# (1,1) ~ (i,j)까지의 합구하기
# 리스트 s는 입력받은 직사각형의 1,1부터 영역 내 모든 수의 합을 저장
for row in range(1, n + 1):
    for col in range(1, m + 1):
        sum[row][col] = sum[row - 1][col] + sum[row][col - 1] - sum[row - 1][col - 1] + retangle[row][col]

# print(sum)


def sumCalculate(x1, y1, x2, y2):
    return sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]

# i, j는 절단 위치

# 첫 번째 경우: 세로로만 분할한 경우 ㅣㅣㅣ
for i in range(1, m-1):
    for j in range(i+1, m):
        r1 = sumCalculate(1, 1, n, i)  # print(n, i, r1)
        r2 = sumCalculate(1, i + 1, n, j)  # print(n, j, r2)
        r3 = sumCalculate(1, j + 1, n, m)
        if res < r1 * r2 * r3:  # 경우의 수는 곱으로 계산함, 최대값 계산
            res = r1 * r2 * r3


# 두 번째 경우: 가로로만 분할한 경우 三
for i in range(1, n-1):
    for j in range(i+1, n):
        r1 = sumCalculate(1, 1, i, m)
        r2 = sumCalculate(i + 1, 1, j, m)
        r3 = sumCalculate(j + 1, 1, n, m)
        if res < r1 * r2 * r3:  # 경우의 수는 곱으로 계산함, 최대값 계산
            res = r1 * r2 * r3

# 세 번째 경우: 전체 세로 분할 후 우측 가로 분할한 경우 ㅏ
for i in range(1, m):
    for j in range(1, n):
        r1 = sumCalculate(1, 1, n, i)
        r2 = sumCalculate(1, i + 1, j, m)
        r3 = sumCalculate(j + 1, i + 1, n, m)
        if res < r1 * r2 * r3:  # 경우의 수는 곱으로 계산함, 최대값 계산
            res = r1 * r2 * r3

# 네 번째 경우: 전체 세로 분할 후 좌측 가로 분할한 경우 ㅓ
for i in range(1, n):
    for j in range(1, m):
        r1 = sumCalculate(1, 1, i, j)
        r2 = sumCalculate(i + 1, 1, n, j)
        r3 = sumCalculate(1, j + 1, n, m)
        if res < r1 * r2 * r3:  # 경우의 수는 곱으로 계산함, 최대값 계산
            res = r1 * r2 * r3

# 다섯번 째 경우: 전체 가로 분할 후 하단 세로 분할한 경우 ㅜ
for i in range(1, n):
    for j in range(1, m):
        r1 = sumCalculate(1, 1, i, m)
        r2 = sumCalculate(i + 1, 1, n, j)
        r3 = sumCalculate(i + 1, j + 1, n, m)
        if res < r1 * r2 * r3:  # 경우의 수는 곱으로 계산함, 최대값 계산
            res = r1 * r2 * r3

# 여섯번 째 경우: 전체 가로 분할 후 상단 세로 분할한 경우 ㅗ
for i in range(1, n):
    for j in range(1, m):
        r1 = sumCalculate(1, 1, i, j)
        r2 = sumCalculate(1, j + 1, i, m)
        r3 = sumCalculate(i + 1, 1, n, m)
        if res < r1 * r2 * r3:  # 경우의 수는 곱으로 계산함, 최대값 계산
            res = r1 * r2 * r3

print(res)