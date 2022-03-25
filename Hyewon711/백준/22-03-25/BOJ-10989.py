# 단순히 sort 하는 경우 메모리 초과가 발생, 주어진 메모리를 주의해야함

import sys # readline 을 통해 입력받는 것이 시간을 줄일 수 있음

n = int(sys.stdin.readline())
arr = [0] * 10001 #배열 확보

for i in range (n): # n만큼 반복
    num = int(sys.stdin.readline())
    arr[num] += 1

for j in range(10001):
    if arr[j] != 0:
        for i in range(arr[j]):
            print(j)