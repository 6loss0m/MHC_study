# 문자열 분석
import sys

while True:
    str = sys.stdin.readline().rstrip('\n')

    if not str:
        break

    # 소문자, 대문자, 숫자, 공백
    l, u, n, s = 0, 0, 0, 0
    for i in str:
        if i.islower():
            l += 1
        elif i.isupper():
            u += 1
        elif i.isdigit():
            n += 1
        elif i.isspace():
            s += 1

    print(l, u, n, s)


