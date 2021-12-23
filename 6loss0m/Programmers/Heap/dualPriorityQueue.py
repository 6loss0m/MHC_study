import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    answer = [0,0]
    for i in operations:       
        if "I" in i:
            insert = int(i[2:])
            heapq.heappush(min_heap, insert)
            heapq.heappush(max_heap, -insert)
        elif i == "D 1" and len(max_heap) != 0 :
            heapq.heappop(max_heap)
            min_heap.pop()
        elif i == "D -1" and len(min_heap) != 0:
            heapq.heappop(min_heap)
            max_heap.pop()
        #print("최대힙",max_heap)
        #print("최소힙",min_heap)
            
    if len(max_heap) != 0:
        answer[0] = -(heapq.heappop(max_heap))
    if len(min_heap) != 0:
        answer[1] = heapq.heappop(min_heap)       
    return answer