# Base Conversion
a,b = map(int,input().split())
m = int(input())
num = list(map(int,input().split()))

n = 0
for i in range(m):
    n += num[m-i-1]*(a**i)

s = ''
arr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
while n:
    s = ' '+s
    s = str(n%b)+s
    n //= b

print(s)