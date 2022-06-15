# BOJ 1525 - 퍼즐
import sys
from collections import deque

# bfs 탐색
def bfs():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    queue = deque([graph])
    visited[graph] = 0

    while queue:

        target = queue.popleft() # queue의 맨 왼쪽 요소를 뽑아서 target에 저장

        # 정리된 상태가 된다면 반복을 멈추고 현재 퍼즐을 만들기 위한 횟수를 리턴
        if target == "123456780":
            return visited[target]

        idx = target.find("0") # 빈 공간에 인덱스를 찾는다.
        x = idx // 3 # 그래프에서 빈 공간의 x 위치  3x3의 x 좌표
        y = idx % 3 # 그래프에서 빈 공간의 y 위치 3x3의 y 좌표

        # 상/하/좌/우 4방향 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 좌표가 퍼즐 범위 안에 있으면
            if 0 <= nx < 3 and 0 <= ny < 3:
                n = nx * 3 + ny # 리스트에서 현재 좌표 위치
                list_target = list(target) # 문자열 퍼즐을 리스트로 변환
                # 빈 공간의 인덱스에 현재 좌표를 넣고 현재 좌표에 빈 공간의 인덱스 값을 넣는다.
                list_target[idx], list_target[n] = list_target[n], list_target[idx]
                new_target = "".join(list_target) # 리스트 퍼즐을 문자열로 변환

                # 현재 퍼즐 모양을 갖는 key 값이 없다면
                if not visited.get(new_target):
                    visited[new_target] = visited[target] + 1 # 횟수 갱신
                    queue.append(new_target) # 탐색 추가

    # 탐색이 끝나도 정리된 상태가 안된다면 -1 리턴
    return -1


graph = ""
for _ in range(3):
    a, b, c = map(str, sys.stdin.readline().split())
    graph += a + b + c
visited = dict() # key : 퍼즐 모양, value : 퍼즐 모양을 만들기 위한 횟수
print(bfs())