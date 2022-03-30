import sys
from collections import deque
n = int(sys.stdin.readline().rstrip())
que=[]
que=deque(que)
for i in range(n):
    com = sys.stdin.readline().rstrip().split()
    if com[0]=='push_front':
        que.appendleft(com[1])
    elif com[0]=='push_back':
        que.append(com[1])
    elif com[0]=='pop_front':
        if len(que)==0:
            print(-1)
        else:
            print(que[0])
            que.popleft()
    elif com[0]=='pop_back':
        if len(que)==0:
            print(-1)
        else:
            print(que[-1])
            que.pop()
    elif com[0]=='size':
        print(len(que))
    elif com[0]=='empty':
        if len(que)==0:
            print(1)
        else:
            print(0)
    elif com[0]=='front':
        if len(que)==0:
            print(-1)
        else:
            print(que[0])
    else:   #back인 경우 해당
        if len(que)==0:
            print(-1)
        else:
            print(que[-1])
