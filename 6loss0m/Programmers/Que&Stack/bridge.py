def solution(bridge_length, weight, truck_weights):
    # 다리 길이만큼의 리스트 생성
    q=[0]*bridge_length
    #print(q)
    sec=0
    while q:
        sec+=1 # 1초 추가
        q.pop(0) # 다리 한칸씩 이동
        if truck_weights: # 트럭 길이가 존재한다면
            # 사용중인 다리길이 + 가장 앞의 트럭 길이가 무게보다 작거나 같은경우
            # 다리를 건널 수 있는 경우
            if sum(q)+truck_weights[0]<=weight: 
                # 다리 리스트에 추가
                q.append(truck_weights.pop(0))
            # 다리를 건널 수 없는 경우
            else:
                q.append(0)
    return sec