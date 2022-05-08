import sys
sys.setrecursionlimit(10000)
from collections import deque

def dfs(v):
    visited[v] = True
    for i in adj[v]:
        if not visited[i]:
            dfs(i)

t = int(sys.stdin.readline().strip())

for _ in range(t):
    n = int(sys.stdin.readline().strip())
    adj = [[] for i in range(n+1)]
    visited = [False]*(n+1)
    count = 0

    num_list = list(map(int, sys.stdin.readline().strip().split()))
    num_list = deque(num_list)
    num_list.appendleft(0)

    for i in range(1, n+1):
        adj[i].append(num_list[i])

    for j in range(1, n+1):
        if not visited[j]:
            dfs(j)
            count +=1
    print(count)