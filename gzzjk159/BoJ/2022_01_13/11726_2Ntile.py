n = int(input())
tile = [0,1,2]
if n<3:
    print(tile[n])
else:
    for i in range(3, n+1):
        tile.append(tile[i-2]+tile[i-1])
    print(tile[n]%10007)