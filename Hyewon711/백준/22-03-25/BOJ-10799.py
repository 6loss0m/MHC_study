# 레이저 = () 으로 표현 쇠막대기 길이는 '(' 시작, ')' 끝

import sys
arr = list(sys.stdin.readline())
stack = []
answer = 0
prev = None

for i in range(len(arr)):
    if arr[i] == '(':
        stack.append(arr[i])
    elif prev == '(' and arr[i] == ')':
        stack.pop()
        answer += len(stack)
    elif prev == ')' and arr[i] == ')':
        answer += 1
        stack.pop()
    prev = arr[i]
print(answer)