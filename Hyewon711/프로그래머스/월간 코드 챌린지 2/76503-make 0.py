# 76503 - 모두 0으로 만들기
# https://prgms.tistory.com/47
# 트리를 루프부터가 아닌 리프 노드부터 거꾸로 탐색

# 노드가 가진 가중치의 총합이 0일 경우엔 모든 가중치를 0으로 만드는 게 가능하지만
# 0이 아닐 경우 모든 가중치를 0으로 만드는 게 불가능하다.
# a는 2 이상이다.
# 0번 노드를 리프 노드(자식이 없는 노드)라 가정하고 DFS를 활용하여
# 자식 노드까지 탐색한 후 다시 부모 노드로 거슬러 올라가며
# 자식 노드의 가중치의 절대값을 누적하면 답을 구할 수 있다.

# 그림에서 보면 알겠지만 행동 횟수는 현재 노드가 가지고 있는 값과 절대값이 동일하다.
# 즉 횟수이기 때문에 플러스를 하든 마이너스를 하든 노드의 가중치가 곧 횟수가 되는 것이다. 따라서 행동 횟수는 절대값의 연산이 필요할 것이다.

import sys
sys.setrecursionlimit(10 ** 6)
result = 0

def dfs(child, parent, graph, a): # dfs 반복
    global result
    print(graph[child])
    print(graph[parent])
    # 자식 노드까지 탐색한 후 다시 부모 노드로 거슬러 올라가며
    # 자식 노드의 가중치의 절댓값을 누적하면 답을 구할 수 있다.
    for c in graph[child]:
        if c != parent: # 재귀호출로 방문 노드를 계속해서 업데이트
            dfs(c, child, graph, a)
    a[parent] += a[child] # 가중치를 계속 더함
    result += abs(a[child]) # 최종적으로 가중치를 더한 값의 절대값이 정답이 된다. (가중치는 횟수와 동일)
    return result

def solution(a, edges):
    if sum(a) != 0: # 만약 가중치의 합이 0 이 아니라면 return -1
        return -1

    n = len(a) # a의 길이
    graph = [[] for i in range(n)] # a의 길이만큼 그래프 그리기

    for node_a, node_b in edges: # 트리의 간선 정보를 그래프에 추가
        graph[node_a].append(node_b)
        graph[node_b].append(node_a)

    dfs(0, 0, graph, a) # 0부터 모든 노드 탐색
    return result