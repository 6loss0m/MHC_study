n = int(input())
point = []
for _ in range(n):
    x, y = map(int, input().split())
    point.append([x, y])

point.sort(key=lambda x: (x[1], x[0]))

for x, y in point:
    print(x, y)