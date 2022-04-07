# 최소 공배수
# 1,45000(45000) / 6,10(30) / 13,17(221)
# 유클리드 호제법
# 최대 공약수
def gcd(x,y):
    mod = x % y
    while mod >0:
        x = y
        y = mod
        mod = x % y
    return y


# 최소 공배수
def lcm(x, y):
    return x * y // gcd(x,y)


n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    print(lcm(a, b))