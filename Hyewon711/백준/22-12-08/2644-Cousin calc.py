"""
2644 - 촌수 계산

두 사람이 몇 촌인지 계산하는 문제.
전 문제들과 동일하게 graph 각 노드를 연결하고 촌수 계산은 깊이를 계산하는 것이므로 완전탐색한다. (bfs/dfs 모두 가능하다)
방문할 때 마다 방문할 때마다 방문처리 체크해주고 촌수를 +1한다., 만약 방문하지 못한 경우엔 그대로 visited 값이 0일 것이다.
그러한 경우는 두 사람의 친척관계가 없는 경우이다. (-1 출력)

"""
import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
x, y = map(int, input().split())
m = int(input())
graph = [ [] for _ in range(n+1) ]
visited = [0] * (n+1) # 방문 정보 확인용, 몇촌인지도 저장할 리스트이다.

def dfs(x) :
    for i in graph[x]:
        if not visited[i] : # 아직 방문을 안했다면
            visited[i] = visited[x]+1 # 방문 후 촌수 +1
            dfs(i) # 재귀

for _ in range (m) : # 가족 관계를 그래프의 연결 요소로 append ( 무방향 그래프 )
    num1, num2 = map(int, input().split())
    graph[num1].append(num2)
    graph[num2].append(num1)


dfs(x) # 구하고자 하는 촌수 관계 시작지점(x)부터 dfs

if visited[y] > 0 : # 찾고자하는 촌수관계 끝지점(y) 출력
    print(visited[y])
else : print("-1")