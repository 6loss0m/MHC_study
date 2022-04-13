n,k = map(int, input().split())
pp = [i for i in range(1, n+1)]
result = []
idx = 0
for i in range(n):
    idx += k-1
    if idx >= len(pp):
        idx %= len(pp)
    result.append(pp.pop(idx))
print("<" + ', '.join(str(i) for i in result) + ">")