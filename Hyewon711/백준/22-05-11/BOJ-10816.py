# BOJ 10816 - 숫자 카드
import sys

n = int(input()) # 상근이가 가지고 있는 숫자 카드의 개수
card = list(map(int, sys.stdin.readline().split())) # 숫자 카드에 적혀있는 정수

m = int(input()) # 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 카드 개수
search = list(map(int, sys.stdin.readline().split())) # 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 정수

card.sort()
ans = {}

for i in card: # card의 중복을 미리 카운트
    if i not in ans:
        ans[i] = 1
    else :
        ans[i] += 1

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
            break
    if card[mid] == i :
        print(ans[i], end=' ')
    else:
        print(0, end=' ')