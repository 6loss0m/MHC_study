# 2597 - 줄자접기
# 유의점 : 줄자를 어느 방향으로 접던 잡으면 왼쪽에 있던 점이 오른쪽으로 이동하게 된다.
s, m = 0, 0
e = int(input()) # 줄자의 마지막 위치, 즉 길이
r1, r2 = map(int, input().split()) # 빨간 점 1, 2
b1, b2 = map(int, input().split()) # 파란 점 1, 2
y1, y2 = map(int, input().split()) # 노란 점 1, 2


if r1 != r2 : # 빨간점이 서로 다른 경우 접어서 두 점이 만나도록 하기
    m = (r1 + r2)/2
    b1 = m + abs(m-b1)
    b2 = m + abs(m-b2)
    y1 = m + abs(m-y1)
    y2 = m + abs(m-y2)
    s = m + abs(m-s)
    if s > e :
        e = s
    s = m

if b1 != b2 : # 파란점이 서로 다른 경우 접어서 두 점이 만나도록 하기
    m = (b1 + b2)/2
    y1 = m + abs(m-y1)
    y2 = m + abs(m-y2)
    s = m + abs(m-s)
    if s > e :
        e = s
    s = m

if y1 != y2 : # 노란점이 서로 다른 경우 접어서 두 점 만나도록 하기
    m = (y1 + y2)/2
    s = m + abs(m-s)
    if s > e :
        e = s
    s = m

print(e-s)