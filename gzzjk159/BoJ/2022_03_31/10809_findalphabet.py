str = input()
alpha = [-1]*26
idx = 0
for i in str:
    fa = ord(i)-97
    if alpha[fa] == -1:
        alpha[fa]=idx
    else:
        pass
    idx += 1
for i in range(26):
    print(alpha[i],end=" ")
# print(*alpha)