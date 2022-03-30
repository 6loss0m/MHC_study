str = input()

alpha_count = [0]*26

for i in str:
    alpha_count[ord(i)-97]+=1

# print(*alpha_count) 주소로도 표현 가능

for j in alpha_count:
    print(j, end=' ')