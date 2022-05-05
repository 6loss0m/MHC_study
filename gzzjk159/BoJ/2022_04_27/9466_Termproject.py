# import sys
# sys.setrecursionlimit(10000)
# from collections import deque
# t= int(sys.stdin.readline().strip())
#
# def dfs(v, g, c):
#     visited[v] = True
#     group[v] = g
#     for k in graph[v]:
#         if not visited[k]:
#             dfs(k,g,c+1)
#         if group[k]==group[v]:
#             return c
#         if k==v:
#             return 1
# for _ in range(t):
#     n = int(sys.stdin.readline().strip())
#
#     graph = [[] for i in range(n+1)]
#     group = [0]*(n+1)
#     visited = [False] * (n+1)
#
#     team_num = [0] + list(map(int, sys.stdin.readline().strip().split()))
#
#     for j in range(1,n+1):
#         graph[j].append(team_num[j])
#
#     g_n = 1
#     result = 0
#     for j in range(1, n+1):
#         if not visited[j]:
#             count = 1
#             dfs(j,g_n,count)
#             g_n += 1
#             result += count
#     print(n-result)
import sys

sys.setrecursionlimit(10 ** 7)

input = sys.stdin.readline


def dfs(x):
    global ans
    vis[x] = True
    cycle.append(x)
    num = arr[x]

    if vis[num]:
        if num in cycle:
            ans += cycle[cycle.index(num):]
        return
    else:
        dfs(num)


t = int(input())

for _ in range(t):
    n = int(input())
    arr = [0] + list(map(int, input().split()))
    vis = [False] * (n + 1)
    ans = []

    for i in range(1, n + 1):
        if not vis[i]:
            cycle = []
            dfs(i)
    print(n - len(ans))