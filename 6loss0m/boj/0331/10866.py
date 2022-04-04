# 데큐
from sys import stdin

n = int(stdin.readline())
que = []
for i in range(n):
    op = stdin.readline().split()
    if op[0] == 'push_front':
        que.insert(0,int(op[1]))
    if op[0] == 'push_back':
        que.append(int(op[1]))
    elif op[0] == 'pop_front':
        if len(que) == 0:
            print(-1)
        else:
            print(que.pop(0))
    elif op[0] == 'pop_back':
        if len(que) == 0:
            print(-1)
        else:
            print(que.pop())
    elif op[0] == 'size':
        print(len(que))
    elif op[0] == 'empty':
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif op[0] == 'front':
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])
    elif op[0] == 'back':
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])
    #print(que)