import sys

n = int(sys.stdin.readline().strip())
pn = 2

while n !=1:
    if n%pn==0:
        print(pn)
        n //= pn
    else:
        pn +=1
# 처음 생각 소수를 구한 후 소수리스트로 나누면서 출력하는 줄 알았지만
# 그냥 숫자 하나씩 늘려가며 출력... 허무
# def prime(num):
#     if num==1:
#         return False
#     for i in range(2, int(num**(1/2))+1):
#         if num%i==0:
#             return False
#     return True
#
# for i in range(2, n+1):
#     if prime(i):
#         pl.append(i)
#
# prime(n)
#
# idx = 0
# if n == 1:
#     exit()
# else:
#     while n !=1:
#         if n % pl[idx]==0:
#             print(pl[idx])
#             n //=pl[idx]
#         else:
#             idx += 1
