# 2007 년

month = [31,28,31,30,31,30,31,31,30,31,30,31]
day = ['SUN','MON','TUE','WED','THU','FRI','SAT']
cur = 0

m,n = map(int,input().split())
sum = n
for i in range(m-1): sum+= month[i]

print(day[sum%7])