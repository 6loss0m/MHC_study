# 소수 찾기
N=int(input())
num=[int(i) for i in input().split()]
count=0

for i in num:
    if i!=1:
        if i==2:
            count+=1
        else:
            for j in range (2,i):
                if i%j==0:
                    break
                elif j==i-1:
                    count+=1

print(count)