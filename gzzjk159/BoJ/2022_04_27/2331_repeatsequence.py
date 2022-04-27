import sys

a, p = map(int, sys.stdin.readline().strip().split())

d = [a]
while True:
    num = 0
    for s in str(d[-1]):
        num += int(s) ** p

    if num in d:
        break

    d.append(num)

print(d.index(num))