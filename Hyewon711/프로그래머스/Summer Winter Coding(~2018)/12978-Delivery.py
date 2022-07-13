# 12978 - 배달
# 다익스트라 알고리즘 : 대표적인 최단경로 탐색 알고리즘
# 힙 구조를 사용하면 시간복잡도는 O(nlogn) 으로 가능하다
"""
1. 출발 노드와, 도착 노드를 설정
2. 알고 있는 모든 거리 값을 부여
3. 출발 노드부터 시작하여, 방문하지 않은 인접 노드를 방문, 거리를 계산한 다음, 현재 알고있는 거리보다 짧으면 해당 값으로 갱신한다.
4. 현재 노드에 인접한 모든 미방문 노드까지의 거리를 계산했다면, 현재 노드는 방문한 것이므로, 미방문 집합에서 제거한다.
5. 도착 노드가 미방문 노드 집합에서 벗어나면, 알고리즘을 종료한다

파이썬으로 다익스트라 알고리즘 구현하기 https://justkode.kr/algorithm/python-dijkstra
"""

import heapq

def dijkstra(dist, adj):
    # 출발노드를 기준으로 각 노드들의 최소비용 탐색
    heap = []
    heapq.heappush(heap, [0,1])  # 거리,노드 (시작 노드부터 탐색 시작)
    while heap:
        cost, node = heapq.heappop(heap)
        for c, n in adj[node]: # 방문하지 않은 인접 노드를 방문
            if cost+c < dist[n]: # 거리를 계산한 다음, 현재 알고있는 거리보다 짧으면 해당 값으로 갱신
                dist[n] = cost+c
                heapq.heappush(heap, [cost+c,n])


def solution(n, road, k):
    dist = [float('inf')]*( n+1 )  # dist 배열 만들고 최소거리 갱신 (양의 무한대 inf로 초기화)
    dist[1] = 0  # 시작노드는 거리 0 ( 자기 자신이므로 )
    adj = [[] for _ in range( n+1 )]  # 인접노드와 거리를 기록할 배열 adj

    for r in road: # 각 마을을 연결하는 도로의 정보 road에서 a -> b , b -> a 최단 거리 추가 (양방향)
        adj[r[0]].append([r[2], r[1]])
        adj[r[1]].append([r[2], r[0]])
    dijkstra(dist, adj) # 다익스트라 함수 (거리, 인접노드 배열)
    return len([i for i in dist if i <= k]) # i가 k보다 작거나 같은 거리의 개수가 출력
    # 즉, 위에서 반복하는 for문의 길이는 배달이 가능한 마을의 개수가 된다.