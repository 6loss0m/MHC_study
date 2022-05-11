# BOJ 2805 - 나무 자르기
import sys

n, m = map(int, sys.stdin.readline().split()) # 나무 수, 가져갈 나무 길이
arr = list(map(int, input().split())) # 나무 길이를 n개만큼 입력받는다.

start = 0
end = max(arr)

while (start <= end): # 이분탐색, start 가 end 보다 크거나 같아지는 경우 탐색을 종료한다.
    mid = (start + end) // 2 # 절반으로 나눈 후
    sum = 0 # 잘려진 나무의 합
    for i in arr:
        if i > mid : # mid값보다 큰 나무는 잘리게된다.
            sum += i - mid
        if sum >= m : # sum이 m보다 크거나 같다면 더이상 for문을 반복할 필요가 없다. break를 안해주는 경우 시간초과
            break
    if sum >= m : # 가져갈 나무 길이보다 많이 잘렸다면
        start = mid + 1 # mid + 1 을 start에 넣어 비교점 start를 변경한다.
    else: # 덜 잘린 상태라면
        end = mid - 1 # cnt가 n 보다 작은 경우 비교점 end를 변경한다.
print(end)
