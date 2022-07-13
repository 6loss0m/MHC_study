# BOJ 1806 - 부분합
# 이 문제도 2003와 동일하게 투 포인터로 접근했다. S (0 < S ≤ 100,000,000)

import sys

n, s = map(int, sys.stdin.readline().split()) # 수열 A[n], 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것을 찾기위한 변수
arr = list(map(int, sys.stdin.readline().split()))

cnt = 0
left, right = 0, 1 # 투 포인터
sum = arr[left] # 가장 왼쪽 0
min_length = sys.maxsize # 최소 길이를 저장할 변수

# 현재 구간의 합이 s보다 작다면 현재 구간의 끝점을 늘려야 한다. (right+1)
# 반대로 현재 구간의 합이 s 이상이라면 시작점을 늘려야 한다. (left+1)

# 투 포인터로 정답 구하기
while left < n: # 수열을 모두 확인할때까지 반복
    if sum >= s : # sum의 값이 s 이상이라면
        min_length = min(min_length, right - left) # 구하고자 하는 정답인 최소 길이
        sum -= arr[left] # a[left]를 sum에서 빼주어 현재 sum의 값을 수정한다.
        left += 1 # 왼쪽 포인터 한칸 이동

    elif right == n : # 만약 right가 끝까지 도달한 경우
        break # break

    else :
        sum += arr[right] # 현재 위치한 arr[right] 값을 sum에 추가
        right += 1 # 오른쪽 포인터 한칸 이동

if min_length == sys.maxsize : # 정수의 최대값/최솟값이 같은경우
    print(0)
else:
    print(min_length)