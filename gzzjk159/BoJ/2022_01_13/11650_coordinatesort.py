n = int(input())
point = []
for _ in range(n):
    x, y = map(int, input().split())
    point.append([x, y])

point.sort()

for x, y in point:
    print(x, y)