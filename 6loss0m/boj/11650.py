n = int(input())
pos = []
for i in range(n):
    x,y = map(int,input().split())
    pos.append([x,y])
pos.sort()
for x,y in pos :
    print(x,y)