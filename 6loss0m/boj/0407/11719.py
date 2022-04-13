# 그대로 출력하기 2
while True:
    try:
        print(input())
    except EOFError:
        break
# https://www.acmicpc.net/board/view/28332