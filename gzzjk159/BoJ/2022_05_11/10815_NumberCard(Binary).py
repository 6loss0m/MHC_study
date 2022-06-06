import sys

input = sys.stdin.readline

n = int(input().strip())
card_list = list(map(int, input().strip().split()))
m = int(input().strip())
new_list = list(map(int, input().strip().split()))

card_list.sort()

def binary(check ,target ,start , end):
    while start<=end:
        mid = (start+end)//2
        if check[mid]==target:
            return True
        elif check[mid]>target:
            end = mid-1
        else:
            start = mid+1
    return False

for i in range(m):
    if binary(card_list, new_list[i], 0, n-1):
        print(1, end=" ")
    else:
        print(0, end=" ")