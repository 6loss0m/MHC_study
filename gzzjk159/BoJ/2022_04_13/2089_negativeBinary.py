import sys

n = int(sys.stdin.readline().strip())
answer = []

if n == 0:
    print(0)
else:
    while n!=0:
        if n%-2:
            n = n//(-2) +1
            answer.append(1)
        else:
            n//=-2
            answer.append(0)
answer = list(reversed(answer))
for i in range(len(answer)):
    print(answer[i], end="")