import sys

n = int(sys.stdin.readline().rstrip())
numstr = sys.stdin.readline().rstrip()
sum=0
for i in numstr:
    sum += int(i)
print(sum)