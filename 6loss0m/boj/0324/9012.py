# 괄호
import sys

def sol(op):
    stack = []
    top = -1
    for i in range(len(op)) :
        #print(i,op[i],top,stack)
        if op[i] == '(':
            top += 1
            stack.append(op[i])
        elif op[i] == ')':
            if top == -1:
                return 'NO'
            else:
                top -= 1
                stack.pop()
   # print(stack)
    if top == -1:
        return 'YES'
    else:
        return 'NO'

n = int(sys.stdin.readline())
result = []
for _ in range(n):
    # input()으로 할시 시간초과
    str = sys.stdin.readline()
    result.append(sol(str))
for i in result:
    print(i)