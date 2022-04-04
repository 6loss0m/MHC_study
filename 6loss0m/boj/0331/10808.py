# 알파벳 개수
import sys
str = sys.stdin.readline()
abc = [0]*26
# str에 '\n'도 포함되어있음.
for i in range(len(str)-1):
    abc[ord(str[i])-ord('a')] += 1
for j in abc:
    print(j,end=' ')
#print(*abc)