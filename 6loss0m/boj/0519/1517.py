# 버블 소트

#merge하는 과정에서 3가지의 리스트를 각각 왼쪽 리스트, 오른쪽 리스트, 새로운 리스트라 부르겠다.
# 1. 왼쪽 리스트의 값을 새로운 리스트에 채울 경우 swap += cnt
# 2. 오른쪽 리스트의 값을 새로운 리스트에 채울 경우 cnt += 1

import sys

read = lambda: sys.stdin.readline().rstrip()


def merge_sort(start, end):
    global swap_count, A

    if start < end:
        mid = (start + end) // 2
        merge_sort(start, mid)
        merge_sort(mid + 1, end)

        a, b = start, mid + 1
        temp = []

        while a <= mid and b <= end:
            if A[a] <= A[b]:
                temp.append(A[a])
                a += 1
            else:
                temp.append(A[b])
                b += 1
                swap_count += (mid - a + 1)

        if a <= mid:
            temp = temp + A[a:mid + 1]
        if b <= end:
            temp = temp + A[b:end + 1]

        for i in range(len(temp)):
            A[start + i] = temp[i]


swap_count = 0
N = int(read())
A = list(map(int, read().split()))
merge_sort(0, N - 1)
print(swap_count)

# https://gaza-anywhere-coding.tistory.com/105