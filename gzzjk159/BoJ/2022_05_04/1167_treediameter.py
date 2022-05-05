import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n = int(input())

graph = [[]for i in range(n+1)]

def dfs(x, wei):
    for i in graph[x]:
        a, b = i
        if distance[a] == -1:
            distance[a] = wei + b
            dfs(a, wei + b)

for i in range(n):
    v_list = list(map(int, input().strip().split()))
    for j in range(1,len(v_list),2):
        if v_list[j] == -1:
            break
        graph[v_list[0]].append([v_list[j],v_list[j+1]])
        graph[v_list[j]].append([v_list[0],v_list[j+1]])

# 1번 노드에서 가장 먼 곳을 찾는다.
distance = [-1] * (n + 1)
distance[1] = 0
dfs(1, 0)

# 위에서 찾은 노드에 대한 가장 먼 노드를 찾는다.
start = distance.index(max(distance))
distance = [-1] * (n + 1)
distance[start] = 0
dfs(start, 0)

print(max(distance))