# 그대로 출력하기
import sys

while True:
    str = sys.stdin.readline().rstrip('\n')

    if not str:
        break
    print(str)