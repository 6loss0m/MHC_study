import sys
# input() 내장 함수는 sys.stdin.readline()과 비교해서 prompt message를 출력하고
# 개행 문자를 삭제한 값을 리턴하기 때문에 느리다.

N = int(input())
result = list()

for i in range(N):
    result.append(int(sys.stdin.readline()))
result.sort()
    
for i in result:
    print(i)