import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K and len(scoville) > 1:
        s1 = heapq.heappop(scoville)
        s2 = heapq.heappop(scoville)
        heapq.heappush(scoville, s1 + (s2*2))
        answer = answer + 1
        #print(scoville)
    if len(scoville) == 1 and scoville[0] < K:
        return -1
    return answer