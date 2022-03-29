import sys
n = int(sys.stdin.readline())
stack = []
for i in range(n):
    comnum = sys.stdin.readline().split()
    if comnum[0]=="push":
        stack.append(int(comnum[1]))
    elif comnum[0]=="pop":
        if stack:
            pop_num=stack.pop()
            print(pop_num)
        else:
            print(-1)
    elif comnum[0]=="size":
        print(len(stack))
    elif comnum[0]=="empty":
        if stack:
            print(0)
        else:
            print(1)
    elif comnum[0]=="top":
        if stack:
            print(stack[-1])
        else:
            print(-1)