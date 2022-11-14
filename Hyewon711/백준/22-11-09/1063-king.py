# 1063 - king
# 유의사항 : 돌과 같은 곳으로 이동할 때는 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동

king, stone, n = input().split()
n = int(n)
k_x = ord(king[0])-65
k_y = int(king[1])-1 # 왕의 위치좌표
s_x = ord(stone[0])-65
s_y = int(stone[1])-1 # 돌의 위치좌표
size = 8 # 8*8의 체스판 / 0 ~ 8

"""
x축(열)이 알파벳으로 이루어져 있기에 이를 숫자로 변환해주자. 
열은 문자로 이루어져 있으므로 ord()로 정수 변환 값에 - 65를 통해 0~8 값을 가져올 수 있다.
y축은 0부터가 아닌 1부터 체스판이 시작하므로 -1 
"""

def check(k, s): # king, stone 좌표 확인
    if k==s : # 같은 위치에 놓이게되면
        return 1 # 이동 불가
    else : return 0

for _ in range(n) :
    command = input()

    if command == 'L' : # 1) 왼쪽 이동
        if 0 <= k_x-1 < size :
            k_x -= 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_x-1 < size : # 체스판 안에 존재하는지 확인
                    s_x -= 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_x += 1

    elif command == 'R' : # 2) 오른쪽 이동
        if 0 <= k_x+1 < size :
            k_x += 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_x+1 < size : # 체스판 안에 존재하는지 확인
                    s_x += 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_x -= 1

    elif command == 'T' : # 3) 위쪽 이동
        if 0 <= k_y+1 < size :
            k_y += 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_y+1 < size : # 체스판 안에 존재하는지 확인
                    s_y += 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_y -= 1

    elif command == 'B' : # 4) 아래쪽 이동
        if 0 <= k_y-1 < size :
            k_y -= 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_y-1 < size : # 체스판 안에 존재하는지 확인
                    s_y -= 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_y += 1

    elif command == 'LT' : # 5) 북서쪽 이동
        if 0 <= k_x-1 < size and 0 <= k_y+1 < size :
            k_x -= 1
            k_y += 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_x-1 < size and 0 <= s_y+1 < size : # 체스판 안에 존재하는지 확인
                    s_x -= 1
                    s_y += 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_x += 1
                    k_y -= 1

    elif command == 'LB' : # 6) 북남쪽 이동
        if 0 <= k_x-1 < size and 0 <= k_y-1 < size :
            k_x -= 1
            k_y -= 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_x-1 < size and 0 <= s_y-1 < size : # 체스판 안에 존재하는지 확인
                    s_x -= 1
                    s_y -= 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_x += 1
                    k_y += 1

    elif command == 'RT' : # 7) 북동쪽 이동
        if 0 <= k_x+1 < size and 0 <= k_y+1 < size :
            k_x += 1
            k_y += 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_x+1 < size and 0 <= s_y+1 < size : # 체스판 안에 존재하는지 확인
                    s_x += 1
                    s_y += 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_x -= 1
                    k_y -= 1

    elif command == 'RB' : # 8) 북남쪽 이동
        if 0 <= k_x+1 < size and 0 <= k_y-1 < size :
            k_x += 1
            k_y -= 1
            if check((k_x, k_y),(s_x, s_y)): # 만약 돌이 있다면?
                if 0 <= s_x+1 < size and 0 <= s_y-1 < size : # 체스판 안에 존재하는지 확인
                    s_x += 1
                    s_y -= 1
                else : # 체스판 밖으로 나간다면 원위치로
                    k_x -= 1
                    k_y += 1

print(chr(k_x+65)+str(k_y+1))
print(chr(s_x+65)+str(s_y+1))