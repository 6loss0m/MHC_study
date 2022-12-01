"""

2503 - 숫자 야구
스트라이크 : 세자리의 수에 있는 숫자들 중 세자리 수의 동일한 자리에 위치한 경우
볼 : 숫자가 존재하나 다른 위치의 경우
n은 질문 개수 (1 ≤ n ≤ 100)

1) 영수는 1에서 9까지의 서로 다른 숫자 세개로 세자리 수를 구성해야 한다. (순열)
2) 민혁이가 질문한 숫자를 str로 바꾸어 하나씩 비교하고 스트라이크와 볼을 count한다.

"""

import sys
from itertools import permutations

n = int(input()) # 민혁이가 영수에게 물어볼 질문 개수
quest = [] # 민혁이가 질문한 세 자리 수와 영수가 답한 스트라이크, 볼의 개수
cnt = 0 # 가능성이 있는 답의 총 개수
items = [1,2,3,4,5,6,7,8,9] # 세자리를 이루는 수 1~9
number = list(permutations(items,3)) # 9P3 순열을 number에 만들어놓기.

for _ in range(n): # 질문 개수만큼 quest를 채워나가기
    num = list(map(int,sys.stdin.readline().split()))
    quest.append(num)

for num in number: # 1 for : 9P3 순열만큼 반복.
    flag = 0 # 조건 확인용 flag

    for i in range(n): # 2 for
        s, b = 0,0 # 스트라이크, 볼
        num_str = list(map(int,str(quest[i][0]))) # 민혁이가 물어보는 수

        for j in range(3): # 3 for : 세자리 수의 각 자리를 비교할 것.
            if num[j] == num_str[j]: s += 1 # 각 자리의 수를 비교하고 일치한다면 스트라이크 +1
            else: # 만약 일치하지않은 경우 볼이 있는지 확인
                if num[j] in num_str: b += 1 # 동일하게 각 자리의 수를 비교하고, 다른 자리지만 일치하는 수가 있다면? 볼 +1
        if s != quest[i][1] or b != quest[i][2]: # quest에 저장된 스트라이크, 볼이 for문을 돌렸을 때 나온 s, b의 값과 다른 경우
            flag = 0 # flag를 0으로 바꾸고 for문 break.
            break
        else: flag = 1 # 같은 경우 flag를 1로 바꾼다.
    if flag == 1: cnt += 1 # 가능성이 있는 답의 총 개수를 카운트한다.

print(cnt)