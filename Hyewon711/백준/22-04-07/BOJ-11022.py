cases = int(input())
for i in range(cases):
    a,b = map(int, input().split())
    ans = a + b
    print("Case #%s: %s + %s = %s"%(i+1, a, b, ans ))