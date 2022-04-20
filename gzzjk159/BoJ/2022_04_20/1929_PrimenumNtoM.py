import sys

m,n = map(int, sys.stdin.readline().strip().split())

def prime(num):
    if num==1:
        return False
    for i in range(2, int(num**(1/2))+1):
        if num%i==0:
            return False
    return True

for j in range(m,n+1):
    if prime(j):
        print(j)