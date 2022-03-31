import sys

n = sys.stdin.readline()

str = "abcdefghijklmnopqrstuvwxyz"

for i in range(len(str)):
    answer = n.find(str[i])
    print(answer, end=' ') # count 숫자 사이 공백
    
# string.find(찾을 문자)
# string.find(찾을 문자, 시작 Index)
# string.find(찾을 문자, 시작 Index, 끝 Index)
# find 메서드는 "찾을 문자" 혹은 "찾을 문자열"이 존재하는지 확인하고, 
# 찾는 문자가 존재 한다면 해당 위치의 index를 반환해주고 찾는 문자가 존재 하지 않는다면 -1 을 반환합니다.