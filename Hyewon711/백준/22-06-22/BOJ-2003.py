# BOJ 2003 - 수들의 합 2
# 투 포인터 알고리즘, O(n), 양끝단에서 하나씩 이동하면서 알맞은 수를 찾음
# 이분탐색과 다른 점 => 시간복잡도, 이분탐색은 중간점 mid로 시작점과 끝점을 이동시키는 방식, 정렬된 데이터에 쓰는 방식

import sys

n, m = map(int, sys.stdin.readline().split()) # 수열 A[n], 찾고자하는 값 m
arr = list(map(int, sys.stdin.readline().split()))

cnt = 0
left, right = 0, 1 # 투 포인터
sum = arr[left] # 가장 왼쪽 0

# 현재 구간의 합이 M보다 작다면 현재 구간의 끝점을 늘려야 한다. (right+1)
# 반대로 현재 구간의 합이 M보다 크다면 시작점을 늘려야 한다. (left+1)

# 투 포인터로 정답 구하기
while left < n: # 수열을 모두 확인할때까지 반복
    if sum == m: # 만약 현재 위치에 찾고자 하는 값이 있다면
        cnt += 1 # 경우의 수 추가
        sum -= arr[left] # a[left]를 sum에서 빼주어 현재 sum의 값을 수정한다.
        left += 1 # 다음 자리 이동

    if right == n and sum < m: # 만약 right가 끝까지 도달한 경우, sum 값이 m보다 작은 경우 => right를 더이상 늘릴 수 없으므로
        break # break

    elif sum < m: # 현재 구간의 합이 m보다 작은 경우 (right+1)
        sum += arr[right] # 현재 위치한 arr[right] 값을 sum에 추가
        right += 1

    elif sum > m: # 현재 구간의 합이 m보다 큰 경우 (left+1)
        sum -= arr[left]
        left += 1

print(cnt)