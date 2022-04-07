# 최대공약수와 최소공배수
a, b = map(int, input().split())

def gcd(x,y):
    mod = x % y
    while mod >0:
        x = y
        y = mod
        mod = x % y
    return y

def lcm(x, y):
    return x * y // gcd(x,y)

print(gcd(a, b))
print(lcm(a, b))