# 나무 자르기
# 벌목 높이를 움직여 필요 나무 길이를 채우는지

N, M = map(int, input().split())
tree = list(map(int, input().split()))
start, end = 1, max(tree) #이분탐색 처음과 끝위치

while start <= end:
    mid = (start + end) // 2 #중간 위치
    result = 0 # 나무 길이

    for i in tree:
        if i >= mid:
            result += (i - mid)

    if result >= M:
        start = mid + 1
    else:
        end = mid - 1
print(end)

