# BOJ 10815 - 숫자 카드
import sys

n = int(input()) # 상근이가 가지고 있는 숫자 카드의 개수
card = list(map(int, sys.stdin.readline().split())) # 숫자 카드에 적혀있는 정수

m = int(input()) # 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 카드 개수
search = list(map(int, sys.stdin.readline().split())) # 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 정수

card.sort()
ans = []

for i in search :
    start = 0
    end = len(card)-1
    find = False
    while start <= end :
        mid = (start + end) // 2
        if card[mid] > i :
            end = mid - 1
        elif card[mid] < i :
            start = mid + 1
        else :
            print(1, end=' ')
            find = True
            break

    if find is False :
        print(0, end=' ')
#
# for i in ans :
#     print(i, end=' ')


# 시간초과
# import sys
#
# n = int(input()) # 상근이가 가지고 있는 숫자 카드의 개수
# card = list(map(int, sys.stdin.readline().split())) # 숫자 카드에 적혀있는 정수
#
# m = int(input()) # 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 카드 개수
# search = list(map(int, sys.stdin.readline().split())) # 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 정수
#
# start = 0
# end = max(search)
# ans = []
#
# for i in range (len(card)) :
#     if search[i] in card :
#         ans.append("1")
#     else :
#         ans.append("0")
#
# print (ans)