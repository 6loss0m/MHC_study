# 런타임에 생성해서 사용할 수 있는 익명 함수
# lambda 사용법 lambda 매개변수 : 표현식
# filter 예시 
# >>> a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
#>>> list(map(lambda x: str(x) if x % 3 == 0 else x, a))
# [1, 2, '3', 4, 5, '6', 7, 8, '9', 10]

import sys
input = sys.stdin.readline # *추가. 입력 안하는 경우 시간초과가 나타남

n = int(input()) # 카드 개수
dic = {} # 딕셔너리 (key-value)

for i in range(n):
    tmp = int(input()) # 카드에 적혀있는 정수 
    if tmp in dic: 
        dic[tmp] += 1 # 카드에 적혀있는 정수 dic[tmp]에 따라 value 값을 +1 해준다.
    else: 
        dic[tmp] = 1 # 카드에 적혀있는 정수가 처음 입력될 경우 1 

dic = sorted(dic.items(), key=lambda x: (-x[1], x[0])) 
# 정렬할 때 lambda 함수를 추가하여 
# 카드 개수(value)를 기준으로 먼저 내림차순으로 정렬 후 (-x[1]) -> 카드개수가 같으면 카드값(key)을 기준으로 오름차순 정렬
print(dic[0][0])