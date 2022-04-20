import sys
import math

n = int(sys.stdin.readline().strip())
num_list = list(map(int, sys.stdin.readline().strip().split()))
result = 0


def prime(num):
    if num == 1:
        return 0
    for i in range(2, int(num**(1/2)) + 1):
        if num % i == 0:
            return 0
    return 1


for j in range(n):
    result += prime(num_list[j])
print(result)