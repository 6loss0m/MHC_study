# 요구사항대로 push, pop, size, empty, top이 입력되면 조건문을 실행할 수 있도록 구현한다.

import sys
n = int(input())
stack = []
for _ in range(n):
    cmd = list(map(str,sys.stdin.readline().split()))
    if cmd[0]=='push': #push X: 정수 X를 스택에 넣는 연산이다.
        stack.append(int(cmd[1]))
        
    elif cmd[0]=='pop': #pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if stack: 
            print(stack.pop())
        else:
            print("-1")
            
    elif cmd[0]=='size': #size: 스택에 들어있는 정수의 개수를 출력한다.
        print(len(stack))
        
    elif cmd[0]=='empty': #empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
        if len(stack)==0:
            print(1)
        else:
            print(0)
            
    elif cmd[0]=='top': # top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if stack:
            print(stack[-1])
        else:
            print("-1")