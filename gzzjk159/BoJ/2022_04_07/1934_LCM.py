import sys
n = int(sys.stdin.readline().rstrip())


def gcd(a,b):
    while b>0:
        a,b = b ,a%b
    return a


def lcm(a,b):
    return (a*b)//gcd(a,b)


for i in range(n):
    a,b = map(int, sys.stdin.readline().rstrip().split())
    print(lcm(a,b))