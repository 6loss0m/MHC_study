# 1. 레이저 찾기
# 2. 레이저 근처 쇠 찾기

# 쇠막대기
import sys
iron = sys.stdin.readline()
stack = []
result = 0
top = -1

for i in range(len(iron)):
    if iron[i] == '(':
        top += 1
        stack.append(iron[i])
    elif iron[i] == ')':
        stack.pop()
        top -= 1
        # 레이저인 경우
        if iron[i-1] == '(':
            #print('레이저!')
            result += (top+1)
        # 레이저가 아닌경우
        else:
            result += 1
        #print(result)
    #print(stack)
print(result)