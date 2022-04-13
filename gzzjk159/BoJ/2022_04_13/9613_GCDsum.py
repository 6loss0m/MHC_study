import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())

def gcd(a,b):
    while b>0:
        a,b = b,a%b
    return a

for i in range(t):
    n_list = list(map(int, sys.stdin.readline().strip().split()))
    n_list = deque(n_list)
    n = n_list.popleft()
    n_sum = 0
    for j in range(n-1):
        for k in range(j+1,n):
            n_sum += gcd(n_list[j],n_list[k])
    print(n_sum)