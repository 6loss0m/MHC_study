# BOJ 2446 - 별 찍기 - 9
n = int(input())

for i in range (1, 2*n):
    if i <= n :
        print(" "*(i-1) + "*"*(2*(n-i)+1))
    if i > n :
        print(" "*(2*n-i-1) + "*"*(2*(i-n)+1))
