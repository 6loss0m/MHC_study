def solution(operations):
    # I 숫자 : 큐에 주어진 숫자 삽입
    # D 1 : 큐에서 최댓값 삭제
    # D -1 : 큐에서 최솟값 삭제
    
    heap = []
    for n in operations:
        command, value = n.split()[0], int(n.split()[1])
        if command == 'I': # I가 들어간 경우 
            heap.append(value) #숫자 삽입 (append)
        elif command == 'D' and len(heap) != 0: #D가 들어간경우 & heap이 비어있지 않다면 
            if value < 0: #음수라면
                heap.pop(heap.index(min(heap))) #최솟값 삭제 (pop)
            else: #음수가 아니라면 최댓값 삭제 
                heap.pop(heap.index(max(heap))) 

    if len(heap) == 0: #큐가 비어있는 경우라면 [0, 0] 출력
        return [0, 0]
    else: #아닌 경우 [최솟값, 최댓값] 출력
        return [max(heap), min(heap)]