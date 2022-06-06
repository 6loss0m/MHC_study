import sys

input = sys.stdin.readline

n , m = map(int, input().strip().split())

a = list(map(int, input().strip().split()))
b = list(map(int, input().strip().split()))

for c in b:
    a.append(c)
a.sort()
for i in a:
    print(i, end=" ")
"""
n, m = list(map(int, input().split()))

a = list(map(int, input().split()))
b = list(map(int, input().split()))
answer = []
a_index = 0
b_index = 0

while a_index < n and b_index < m:
    if a[a_index] > b[b_index]:
        answer.append(b[b_index])
        b_index += 1
    else:
        answer.append(a[a_index])
        a_index += 1

if a_index == n:
    answer += b[b_index:m]
else:
    answer += a[a_index:n]

print(*answer)
"""