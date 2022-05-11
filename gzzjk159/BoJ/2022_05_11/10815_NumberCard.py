import sys

input = sys.stdin.readline

n = int(input().strip())

card_list = list(map(int, input().strip().split()))

m = int(input().strip())

new_list = list(map(int, input().strip().split()))

cdic = {}

for i in card_list:
    cdic[i] = 1

for j in new_list:
    if j in cdic:
        print(1, end=" ")
    else:
        print(0, end=" ")