# 물통
import sys
from collections import deque

# a 물통과 b 물통의 경우의 수 저장
def pour(x, y):
    if not visited[x][y]:
        visited[x][y] = True
        q.append((x, y))


# bfs 탐색
def bfs():

    while q:
        # a1 : a 물통의 물의 양, b1 : b 물통의 물의 양, c1 : c 물통의 물의 양
        a1, b1 = q.popleft()
        c1 = c - a1 - b1

        # a 물통이 비어있는 경우 c 물통에 남아있는 물의 양 저장
        if a1 == 0:
            res.append(c1)

        # a -> b
        # a 물통에서 b 물통으로 들어 갈 수 있는 물의 양 체크
        # 체크한 물 양을 a 물통에서 빼주고 b 물통에 넣어 경우의 수 탐색
        water = min(a1, b-b1)
        pour(a1 - water, b1 + water)

        # a -> c
        # a 물통에서 c 물통으로 들어 갈 수 있는 물의 양 체크
        # 체크한 물 양을 a 물통에서 빼주고 경우의 수 탐색
        water = min(a1, c-c1)
        pour(a1 - water, b1)

        # b -> a
        # b 물통에서 a 물통으로 들어 갈 수 있는 물의 양 체크
        # 체크한 물 양을 b 물통에서 빼주고 a 물통에 넣어 경우의 수 탐색
        water = min(b1, a-a1)
        pour(a1 + water, b1 - water)

        # b -> c
        # b 물통에서 c 물통으로 들어 갈 수 있는 물의 양 체크
        # 체크한 물 양을 b 물통에서 빼주고 경우의 수 탐색
        water = min(b1, c-c1)
        pour(a1, b1 - water)

        # c -> a
        # c 물통에서 a 물통으로 들어 갈 수 있는 물의 양 체크
        # 체크한 물 양을 a 물통에서 빼주고 경우의 수 탐색
        water = min(c1, a-a1)
        pour(a1 + water, b1)

        # c -> b
        # c 물통에서 b 물통으로 들어 갈 수 있는 물의 양 체크
        # 체크한 물 양을 b 물통에서 빼주고 경우의 수 탐색
        water = min(c1, b-b1)
        pour(a1, b1 + water)


a, b, c = map(int, sys.stdin.readline().split())


q = deque()
q.append((0, 0)) # a 물통과 b 물통의 물의 양이 0일때부터 탐색

# 방문 여부
visited = [[False] * 201 for _ in range(201)]
visited[0][0] = True

# a 물통의 양이 0일 때 c 물통의 양
res = []

bfs()

# 오름차순 정렬 후 출력
res.sort()
print(*res)