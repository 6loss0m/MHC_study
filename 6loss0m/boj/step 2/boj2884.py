a,b = map(int,input().split())
if b-45 >= 0:
    print(a,b-45)
else:
    if a-1 == -1:
        print(23, b+15)
    else:
        print(a-1, b+15)