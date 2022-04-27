import sys

n = int(sys.stdin.readline().strip())
sum = 1
while True:
    if n == 0:
        break
    else:
        sum *= n
        n -= 1
print(sum)