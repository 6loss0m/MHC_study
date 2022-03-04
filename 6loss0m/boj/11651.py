n = int(input())
pos = []
for i in range(n):
    x,y = map(int,input().split())
    pos.append([y,x])
pos.sort()
for y,x in pos :
    print(x,y)