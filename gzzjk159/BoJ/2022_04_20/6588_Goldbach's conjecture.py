import sys

result = 0

def prime(n):
    if n == 1:
        return False
    for i in range(2,int(n**(1/2))+1):
        if n % i == 0:
            return False
    return True

while True:
    n = int(sys.stdin.readline().strip())
    if n == 0:
        break
    else:
        for i in range(3, (n//2)+1, 2):
            a = i
            b = n-a
            if prime(a) and prime(b):
                print(f'{n} = {a} + {b}')
                break
            if i >= n//2:
                print("Goldbach's conjecture is wrong.")