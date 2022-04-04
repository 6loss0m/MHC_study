import sys

n = list(sys.stdin.readline())

str = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

for i in range(len(str)):
    answer = n.count(str[i])
    print(answer, end=' ') # count 숫자 사이 공백