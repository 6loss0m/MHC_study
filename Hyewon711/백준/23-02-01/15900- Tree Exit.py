"""
    15900 - 나무 탈출
    각각의 리프노드까지 깊이를 구하여
    깊이를 더한 후, (먼저 선을 주었으므로) 홀수인 경우 성원이의 승리, 짝수인 경우 형석이의 승리

"""

import sys
sys.setrecursionlimit(1000000)
sys.stdin = open('input.txt')

N = int(sys.stdin.readline())                       # 노드의 개수
linked = [[] for _ in range(N+1)]                   # 연결 관계
distance = [0] * (N+1)                              # 노드들 거리
distance[1] = 1                                     # 1번 노드의 시작을 거리 1로 설정
need_move = 0                                       # 게임말들이 이동이 필요한 턴의 수

for _ in range(N-1):
    a, b = map(int, sys.stdin.readline().split())   # 노드들 양방향 연결 관계 추가
    linked[a].append(b)
    linked[b].append(a)

def solution(node):
    global need_move

    is_leaf = True                                  # 현재 노드가 리프노드인지 구분을 위함
    for next in linked[node]:
        if not distance[next]:                      # 방문하지 않은 노드들이라면
            distance[next] = distance[node]+1       # 현재 노드까지 거리 갱신
            solution(next)                          # 재귀 호출
            is_leaf = False                         # 다음 노드를 탐색하므로 리프 노드가 아님

    if is_leaf:                                     # 리프 노드라면
        need_move += distance[node]-1               # 게임말 이동이 필요한 칸 수 추가

solution(1)                     # 노드 탐색

if need_move % 2:               # 홀수라면 이김
    print('Yes')
else:                           # 짝수라면 이길 수 없음
    print('No')