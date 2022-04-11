import sys

a, b = map(int, sys.stdin.readline().rstrip().split())


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

print(gcd(a, b))
print(lcm(a, b))
