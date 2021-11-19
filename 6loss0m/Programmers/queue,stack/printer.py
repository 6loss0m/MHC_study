def solution(priorities, location):
    # enumerate : 인덱스 번호와 컬렉션의 원소를 tuple형태로 반환
    queue =  [(i,p) for i,p in enumerate(priorities)]

    answer = 0
    while True:
        cur = queue.pop(0)
        # any : 단 하나라도 참(True)이 있으면 참(True)를 반환하는 함수
        #       반대로 모든 요소가 거짓(False)인 경우에만 거짓(False)을 반환
        # 대기목록중에 현재문서보다 중요도가 높은것이 있는 경우
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == location: # 원하는 위치의 문서에 도달한 경우
                return answer