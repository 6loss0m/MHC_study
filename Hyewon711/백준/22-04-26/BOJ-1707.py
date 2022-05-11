# BOJ 1707 - 이분 그래프
# https://coarmok.tistory.com/entry/%ED%8C%8C%EC%9D%B4%EC%8D%ACpython-%EB%B0%B1%EC%A4%80-1707%EB%B2%88-%EC%9D%B4%EB%B6%84-%EA%B7%B8%EB%9E%98%ED%94%84
from collections import deque

def bfs(num):
    q = deque()
    q.append(num)
    visit[num] = 1
    while q:
        x = q.popleft()
        for i in board[x]:
            if visit[i] == 0:
                visit[i] = -visit[x]
                q.append(i)
            else:
                if visit[i] == visit[x]:
                    return False
    return True


num1 = int(input())
for i in range(num1):
    n,m = map(int, input().split())
    board = [[] for _ in range(n+1)]
    visit = [0] * (n + 1)
    flag = 1
    for _ in range(m):
        a,b = map(int,input().split())
        board[a].append(b)
        board[b].append(a)

    for i in range(1,n+1):
        if visit[i] == 0:
            if not bfs(i):
                flag = -1
                break
    print('YES' if flag == 1 else 'NO')