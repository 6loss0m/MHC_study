# 알파벳 찾기

import sys
str = sys.stdin.readline()
abc = "abcdefghijklmnopqrstuvwxyz"
for i in abc:
    print(str.find(i), end = ' ')
