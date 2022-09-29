# 72413 - 합승 택시 요금
# 특정 정점에서 최소 비용으로 합승해야하는 문제
# 다익스트라 알고리즘 : 다이나믹 프로그래밍을 활용한 대표적인 최단경로 탐색 알고리즘
# ( 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려준다. )

import sys
import heapq

def dijkstra(s, e):
    global graph, length
    # 방문한 노드를 최대값으로 세팅
    visit = [sys.maxsize]*(length+1)
    visit[s] = 0 # 출발 지점 (시작 노드)

    # 우선순위 힙큐에 [cost, node]로 넣어준다
    pq = [[0, s]] # 비용, 노드
    heapq.heapify(pq) # 이미 원소가 들어있는 리스트 힙으로 만들기

    # bfs 진행
    while pq: # 다 돌때까지
        cost, node = heapq.heappop(pq) # 방문한건 pop

        if cost > visit[node]: # 해당노드를 방문하는데 드는 비용이 기존 최소비용보다 큰 경우는 무시
            continue

        # 그 다음으로 방문 가능한 노드 탐색
        for i in graph[node]:
            new_node, new_cost = i[0], i[1]
            # 기존의 비용에 cost 추가해서 새로운 비용
            new_cost += cost

            # 새로운 비용이 기존의 방문노드를 방문하는데 드는 비용보다 작을 경우만 진행
            if new_cost < visit[new_node]:
                # 방문노드 값을 갱신
                visit[new_node] = new_cost
                # heapq에 넣어주고 계속 진행
                heapq.heappush(pq, [new_cost, new_node])

    return visit[e]

def solution(n, s, a, b, fares): # 지점 개수, 출발지점, a의 도착지점, b의 도착지점, 지점 사이의 택시요금
    global graph, length

    answer = sys.maxsize
    graph = [[] for _ in range(n+1)]
    length = n

    for i, j, cost in fares: # 각 지점 사이의 요금값 fares를 기반으로 정점을 잇는 그래프를 그려준다.
        graph[i].append([j, cost])
        graph[j].append([i, cost])

    for i in range(1, n+1):
        # 모든 지점을 돌 때까지 bfs로 탐색
        # 각 노드의 방문할때 비용이 최소인지 아닌지 확인하고 최소비용일때 answer에 저장
        answer = min(answer, dijkstra(s, i) + dijkstra(i, a) + dijkstra(i, b))

    return answer