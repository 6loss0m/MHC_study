#섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

import heapq

def solution(scoville, k):
    heapq.heapify(scoville) #자료구조 heap
    i = 0
    while scoville[0] < k: #k보다 작으면 반복
        if len(scoville) > 1:
            #값 추가 (스코빌지수, (가장 작은 값 + 두 번째로 작은 값 *2 ))
            heapq.heappush(scoville, heapq.heappop(scoville) + (heapq.heappop(scoville) * 2))
            i += 1 
        else: #k 이상 만들 수 없는 경우 return -1
            return -1
    return i # K 이상으로 만들기 위해 섞어야 하는 최소 횟수 +1 

# heapq 활용 : 우선순위대로 자동정렬해주는 자료구조 (우선순위 큐)
# heapq.heapify(list) : 자료구조 heap화
# heapq.heappush(heap, item) : 힙 구조를 유지하면서 값 삽입
# heapq.heappop(heap) : 가장 작은값 반환
# scoville[0]은 scoville에서 가장 작은 값이다. 해당 값이 k보다 작은 이상 계속해서 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)를 반복한다.
# 만약 scoville의 크기가 1인데 그것이 k보다 작은 스코빌 지수를 가진다면 불가능한 것이므로 -1를 반환한다.