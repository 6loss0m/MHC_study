# BOJ 2110 - 공유기 설치
# 이분탐색으로 풀어보는게 좋을 것 같다
import sys

n, c = map(int, sys.stdin.readline().split()) # 집의 수, 공유기의 개수
dist = [int(sys.stdin.readline()) for _ in range(n)] # 거리 입력
dist.sort() # 비교하기 쉽도록 오름차순 정렬

# 공유기 사이 거리 최솟값
start = 1
# 공유기 사이 거리 최댓값
end = dist[n-1] - dist[0]
result = []

while start <= end:
    count = 1
    mid = (start + end) // 2
    current = dist[0] # 공유기가 설치된 집의 위치
    for x in dist:
        if current + mid <= x: # 공유기 설치
            count += 1
            current = x
    if count >= c: # mid 값에 따라 설치된 공유기의 개수가 c 보다 많거나 같으면
        start = mid + 1 # 거리를 늘린다.
        result.append(mid)
    else:
        end = mid - 1 # c 보다 작으면 거리를  줄인다.

print(max(result))