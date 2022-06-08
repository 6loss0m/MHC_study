# 날짜 계산
E, S, M = map(int,input().split())
e, s, m = 0,0,0
sum = 0
while True:
    e += 1
    s += 1
    m += 1
    if e > 15:
        sum += 15
        e = 1
    if s > 28:
        s = 1
    if m > 19:
        m = 1
    if e == E and s == S and m == M :
        sum = sum+e
        break

print(sum)