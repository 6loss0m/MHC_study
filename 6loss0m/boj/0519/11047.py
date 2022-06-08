# 동전 0
import sys
n,k = map(int, sys.stdin.readline().split())
coin = []
for i in range(n):
    coin.append(int(sys.stdin.readline()))

cnt = 0
for i in range(n-1,-1,-1):
    if k == 0 : break
    if k // coin[i] != 0:
        cnt += (k//coin[i])
        k = k % coin[i]
print(cnt)