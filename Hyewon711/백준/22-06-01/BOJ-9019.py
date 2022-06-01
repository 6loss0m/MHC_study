# BOJ 9019 - DSLR
# 파이썬 -> 시간초과, pypy로 돌려야 정답처리
from collections import deque

def bfs():
    q = deque()
    q.append([A, ''])
    visited[A] = 1
    while q:
        x, y = q.popleft() # queue의 맨 왼쪽 요소를 뽑아서 x, y에 저장
        if x == B:
            print(y)
        D = x*2 % 10000 # n을 두 배로 바꾼다. (9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취함)
        if not visited[D]: # 방문여부 확인
            visited[D] = 1 # 방문처리
            q.append([D, y + 'D'])
        S = x - 1 if x != 0 else 9999 # n에서 1을 뺀 결과 n-1 을 저장, 0이라면 9999가 저장
        if not visited[S]: # 방문여부 확인
            visited[S] = 1 # 방문처리
            q.append([S, y + 'S'])
        L = x % 1000 * 10 + x // 1000 #  n의 각 자릿수를 왼편으로 회전
        if not visited[L]:
            visited[L] = 1
            q.append([L, y + 'L'])
        R = x % 10 * 1000 + x // 10 #  n의 각 자릿수를 오른편으로 회전
        if not visited[R]:
            visited[R] = 1
            q.append([R, y + 'R'])

T = int(input())
for _ in range(T):
    A, B = map(int, input().split(' '))
    visited = [0] * 10000
    bfs()