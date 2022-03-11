# 백준 - 1912 연속합
# 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구한다.

n = int(input())
arr = list(map(int, input().split()))

for i in range(1, n):
    arr[i] = max(arr[i], arr[i-1]+arr[i])

print(max(arr))