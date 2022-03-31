# 접미사 배열
str = input()
ans = []
for i in range(len(str)):
    ans.append(str[i:])
ans.sort()
for i in ans:
    print(i)