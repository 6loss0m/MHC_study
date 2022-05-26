import sys

input = sys.stdin.readline

n =int(input().strip())

time_list = list(map(int, input().strip().split()))
time_list.sort()

result = 0
idx = n-1

for i in range(n):
    result += (i+1)*time_list[idx-i]
print(result)