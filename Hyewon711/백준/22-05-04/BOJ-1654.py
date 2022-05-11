# BOJ 1654 - 랜선 자르기
import sys

k, n = map(int, sys.stdin.readline().split())
arr = []

for i in range(k):
    arr.append(int(input()))

start = 1
end = max(arr)

while (start <= end): # 이분탐색, start 가 end 보다 크거나 같아지는 경우 탐색을 종료한다.
    mid = (start + end) // 2 # 절반으로 나눈 후
    cnt = 0
    for i in range(k):
        cnt += arr[i] // mid # 비교하는 arr값을 절반값으로 나눈다.
    if cnt >= n: # 만약 cnt가 n보다 크거나 같은 경우
        start = mid + 1 # mid + 1 을 start에 넣어 비교점 start를 변경한다.
    else:
        end = mid - 1 # cnt가 n 보다 작은 경우 비교점 end를 변경한다.
print(end)