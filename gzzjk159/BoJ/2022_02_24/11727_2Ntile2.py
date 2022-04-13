n=int(input())
tile=[0,1,3]
if n==0:
    print(tile[0])
elif n==1:
    print(tile[1])
elif n==2:
    print(tile[2])
else:
    for i in range(3,n+1):
        tile.append((tile[i-2]*2+tile[i-1])%10007)
    print(tile[n])