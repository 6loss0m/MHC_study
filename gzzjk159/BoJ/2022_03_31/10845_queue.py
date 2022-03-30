import sys
n = int(sys.stdin.readline().rstrip())
que=[]
for i in range(n):
    com = sys.stdin.readline().rstrip().split()
    if com[0]=='push':
        que.append(com[1])
    elif com[0]=='pop':
        if len(que)==0:
            print(-1)
        else:
            print(que[0])
            que.pop(0)
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
    else: #back인 경우 해당
        if len(que)==0:
            print(-1)
        else:
            print(que[-1])
