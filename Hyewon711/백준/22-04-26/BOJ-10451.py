#BOJ 10451 - 순열 싸이클

import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

t = int(input()) # 테스트 케이스 개수

# dfs
def dfs(n):
    if n not in visited:# 방문하지 않은 경우
        visited[n] = True # 방문하지 않은 노드에 대해 연결된 노드 방문 처리
        node = numbers[n] # 다음 노드
    if not visited[node] : # 모든 노드를 방문할 때 까지 재귀함수
        dfs(node)


for _ in range(t):
    n = int(input()) # 순열의 크기
    numbers = [0] + list(map(int, input().split())) # 순열, 각 정수는 공백으로 구분
    visited = [False] * (n+1) # 방문 노드 저장
    cnt = 0 # 연결 요소 개수

    for i in range(1, n+1):
        if not visited[i]: # 탐색하지 않은 정점 dfs 탐색
            dfs(i)
            cnt += 1 # dfs 탐색이 마치면 연결 요소 +1
    print(cnt) # 첫째 줄에 연결 요소의 개수를 출력한다.