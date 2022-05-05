# BOJ 1967 - 트리의 지름

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input()) # 노드의 개수
tree = [[] for _ in range(n+1)]
maxDist = 0 # 최대 지름

for _ in range(n-1):
    a, b, c = map(int,input().split()) # 간선에 대한 정보를 n-1개 줄까지 입력
    tree[a].append((b,c))

def dfs(n, d): # 트리의 지름은 무조건 왼쪽 최장 경로 + 오른쪽 최장 경로
    left, right = 0,0
    for toNode, w in tree[n]:
        r = dfs(toNode,w)
        if left <= right:
            left = max(left,r)
        else:
            right = max(right,r)

    global maxDist # 전역변수의 트리 지름 ( 비교하면서 현재보다 더 큰 값의 지름이 나온다면 갱신 )
    maxDist = max(maxDist, left+right) # 기존의 트리 지름과 왼쪽+오른쪽 경로를 비교한다.
    return max(left+d, right+d) # 더 큰값을 리턴

dfs(1, 0) # 루트 노드의 번호는 항상 1이라고 가정하며, 간선의 가중치는 100보다 크지 않은 양의 정수이다.
print(maxDist)