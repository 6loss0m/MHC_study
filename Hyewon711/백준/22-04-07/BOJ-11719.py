# 입력받은 대로 출력하는 프로그램 작성하기2
# 이전과는 달리 앞에 공백이 있을 수 있다.

while True :
    try:
        print(input())
        
    except EOFError:
        break

# 추가) 단순히 while문만 돌리는 경우 출력초과
# 입력은 최대 100줄로 이루어져 있고, 더 이상 입력값이 없는 경우엔 예외처리를 해주어야하므로 except 를 추가해야한다.
# 또, sys.stdin.readline은 개행문제까지 입력이 되므로 input으로 받아준다.