import sys

input = sys.stdin.readline
m, d = map(int, input().strip().split())
week = ["SUN","MON","TUE","WED","THU","FRI","SAT"]
month=[31,28,31,30,31,30,31,31,30,31,30,31]
result = 0
for i in range(m-1):
    result += month[i]
result += d
result %= 7
print(week[result])