n, x = map(int, input().split())
m = list(map(int,input().split()))
for i in range(n):
    if x > m[i] :
        print(m[i],end=' ')