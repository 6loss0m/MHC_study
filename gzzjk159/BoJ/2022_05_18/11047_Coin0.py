import sys
input = sys.stdin.readline

n,k = map(int , input().strip().split())

coin_list = []

for i in range(n):
    coin_list.append(int(input().strip()))

coin_list.sort( reverse=True )
result = 0

for coin in coin_list:
    if k//coin > 0:
        result += k//coin
        k %= coin

print(result)