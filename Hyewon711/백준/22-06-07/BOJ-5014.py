# BOJ 5014 - 스타트링크
#  U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼 2개만 존재
# 전체 층수 f, 강호가 지금 있는 곳 s, 스타트링크가 있는 곳 g
# 만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다.
# 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력
from collections import deque

f, s, g, u ,d = map(int, input().split())

def bfs(start, end):
    visited = [0] * (f+1) # 방문을 확인할 노드 생성, 길이는 전체층수 + 1
    visited[start] = 1 # 현재 위치에 1 (방문처리)
    queue = deque() # 현재 위치 큐 생성
    queue.append(start)

    while queue: # queue가 빌때까지 반복한다.
        n = queue.popleft() # 첫번째 노드를 pop하고, n에 대입한다.

        if n == end : # 스타트링크 도착
            return visited[n]-1 # 방문처리를 1로 했기에 -1을 해주지않으면 +1된 값으로 출력

        for i in (n+u, n-d) : # up, down
            if 0 < i <= f and visited[i] == 0 : # 만약 1~f 범위내에 있고 방문하지 않았다면
                queue.append(i) # 큐에 현재 위치 추가
                visited[i] = visited[n]+1 # visited에 방문처리

    return "use the stairs" # 스타트 링크에 도착하지 못한 경우

print(bfs(s, g))