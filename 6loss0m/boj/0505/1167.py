# 트리의 지름
import sys
n = int(sys.stdin.readline())
tree = [[] for _ in range(n + 1)]
# [[], [], [], []]
for _ in range(n):
    tmp = list(map(int, sys.stdin.readline().split()))
    i = 1
    while i != len(tmp) - 1:
        tree[tmp[0]].append([tmp[i], tmp[i + 1]])
        i += 2

def dfs(start, result):
    for e, d in tree[start]:
        if result[e] == 0:
            result[e] = result[start] + d
            dfs(e, result)

result1 = [0 for _ in range(n + 1)]
dfs(1, result1) # 임의의 점 1에서 DFS 알고리즘을 이용하여 각 노드들까지의 거리 측정
result1[1] = 0
tmpmax = 0
tmpindex = 0

for i, x in enumerate(result1):
    if tmpmax < x:
        tmpmax = x
        tmpindex = i

result2 = [0 for _ in range(n + 1)]
dfs(tmpindex, result2) # 첫번째 dfs 로 구해진 최대거리 노드에서 새로운 dfs 수행
result2[tmpindex] = 0
print(max(result2))

# https://ca.ramel.be/112