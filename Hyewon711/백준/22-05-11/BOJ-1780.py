# BOJ 1780 - 종이의 개수
# 분할 정복은 재귀적으로 자신을 호출하면서 연산의 단위를 줄여가는 방식

import sys
N = int(sys.stdin.readline())
board = []

for _ in range(N) :
    board.append(list(map(int, sys.stdin.readline().split())))
count = [0, 0, 0] # -1, 0, 1

def cut(x,y,n):
    break_cut = False # #for문 탈출
    check = board[x][y] # 현재 종이 색
    for i in range(x, x+n):
        if break_cut : #break_cut 이 True 라면 break
            break

        for j in range(y, y+n):
            if check != board[i][j] : # 아직 방문하지 않았다면 재귀
                k = n//3
                cut(x, y, k )
                cut(x, y+k, k )
                cut(x, y+2*k, k )
                cut(x+k, y, k )
                cut(x+k, y+k, k )
                cut(x+k, y+2*k, k )
                cut(x+2*k, y, k )
                cut(x+2*k, y+k, k )
                cut(x+2*k, y+2*k, k )

                break_cut = True
                break

    if not break_cut : # break_cut이 False 인 경우 아래 조건문을 실행
        if check == -1:
            count[0] += 1
            return
        elif check == 0:
            count[1] += 1
            return
        else:
            count[2] += 1
            return

cut(0, 0, N)
print(count[0]) # -1
print(count[1]) # 0
print(count[2]) # 1