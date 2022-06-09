# BOJ 10992 - 별 찍기 - 17

n = int(input())

for i in range(n):
    if i==0:
        print(' '*(n-1)+'*')
    elif i==n-1:
        print('*'*(2*n-1))
    else:
        print(' '*(n-1-i)+'*'+' '*(2*i-1)+'*')