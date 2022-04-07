n = int(input())
str = str(input()) # 문자열로 받은 후
sum = 0
for i in range(n):
    sum = sum + int(str[i]) # int로 형변환
print(sum)