import sys

n,m = map(int, sys.stdin.readline().strip().split())

def two_count(n):
    two = 0
    while n !=0:
        n //= 2
        two += n
    return two

def five_count(n):
    five = 0
    while n !=0:
        n //= 5
        five += n
    return five

print(min(two_count(n)-two_count(n-m)-two_count(m), five_count(n)-five_count(n-m)-five_count(m)))

# f = [1]*(n+1)
#
# for i in range(2, n+1):
#     f[i] = f[i-1]*i
#
# num = f[n]//(f[m]*f[n-m])
# num = str(num)
#
# result =0
# for i in range(len(num)-1,-1,-1):
#     if num[i]=='0':
#         result +=1
#     else:
#         break
# print(result)