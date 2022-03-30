# 스택
#
# 문제 :
# 입력 :
# 출력 :
import sys
n = int(sys.stdin.readline())
stack = []
top = -1
for _ in range(n):
    # input()으로 할시 시간초과
    op = sys.stdin.readline().split()
    if op[0] == 'push':
        top += 1
        stack.append(op[1])
    elif op[0] == 'pop':
        if top == -1:
            print(-1)
        else:
            top -= 1
            print(stack.pop())
    elif op[0] == 'size':
        print(top+1)
    elif op[0] == 'empty':
        if top == -1:
            print(1)
        else:
            print(0)
    elif op[0] == 'top':
        if top == -1:
            print(-1)
        else:
            print(stack[top])
    #print(stack)
