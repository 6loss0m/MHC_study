# 팩토리얼 0의 개수
n = int(input())
t = 1
for i in range(1,n+1):
    t = t*i
cnt = 0
while t%10 == 0:
    cnt += 1
    t = t//10
print(cnt)