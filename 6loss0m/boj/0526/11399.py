# ATM
n = int(input())
time = list(map(int, input().split()))
time.sort()
sum = time[0]
cur = time[0]
for i in range(1,n):
    sum += (cur+time[i])
    cur += time[i]

print(sum)