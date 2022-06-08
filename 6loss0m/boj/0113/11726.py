'''
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

1 2 3 5 ...

'''

n = int(input())
d = [0 for _ in range(n+1)]
d[1] = 1
d[2] = 2
if n == 1:
    print(d[1])
elif n == 2:
    print(d[2])
else:
    for i in range(3, n+1) :
        d[i] = (d[i-1] + d[i-2])%10007
    print(d[i])
    print(i)
    for i in range(5):
        print(i)

