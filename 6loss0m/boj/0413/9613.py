# GCD 합

def gcd(x,y):
    mod = x % y
    while mod >0:
        x = y
        y = mod
        mod = x % y
    return y
num = []
n = int(input())
for i in range(n):
    num = list(map(int,input().split()))
    sum = 0
    for j in range(1,len(num)-1):
        for k in range(j+1,len(num)):
            sum += gcd(num[j],num[k])
            #print(num[j],num[k],sum)
    print(sum)