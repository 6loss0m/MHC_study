# 종이의 개수
N = int(input())

paper = [list(map(int, input().split())) for _ in range(N)]

minus = 0
zero = 0
plus = 0

def clip_paper(x, y, n):
    global minus, zero, plus

    num_check = paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if(paper[i][j] != num_check):
                for k in range(3):
                    for l in range(3):
                        clip_paper(x + k * n//3, y + l * n//3, n//3)
                return

    if(num_check == -1):
        minus += 1
    elif(num_check == 0):
        zero += 1
    else:
        plus += 1

clip_paper(0, 0, N)
print(minus)
print(zero)
print(plus)
