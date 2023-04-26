"""
    1446 - 지름길

    지름길은 일방통행, 역주행이 불가능
    운전해야하는 거리의 최솟값을 출력하기

    지름길의 개수 N 고속도로의 길이 D
    두 번째 줄부터는 지름길 시작의 위치, 도착의 위치, 지름길의 길이가 주어진다.

    2. 한 칸 전 위치의 테이블 값+1이 현재 테이블 값보다 작다면 현재 테이블 값을 한 칸 전 위치의 테이블 값+1로 바꾼다.
    3. 현재 위치에 지름길이 있다면 지름길로 건너간 곳의 원래 테이블 값과 지름길로 건너가기 전의 테이블 값+지름길의 거리 중 더 작은 값으로 건너간 곳의 값을 바꾼다.

"""

import sys

n, d = map(int, sys.stdin.readline().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dis = [i for i in range(d+1)] # 최단거리 테이블 생성

# 0 부터 고속도로의 길이까지 반복하여 확인
for i in range(d+1):

    # 지름길로 간 거리와 고속도로로 간 거리를 비교
    dis[i] = min(dis[i], dis[i-1]+1)

    # 지름길을 반복하여 최단 거리를 찾는다.
    for s, e, shortcut in graph:
        if i == s and e <= d and dis[i]+shortcut < dis[e]:
            dis[e] = dis[i]+shortcut

# 고속도로의 끝에 도착했을 때까지 걸린 거리를 출력
print(dis[d])