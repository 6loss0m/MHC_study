# 60061 - 기둥과 보 설치

def check(answer): # 기둥을 설치, 삭제할 때 마다 전체 탐색 
    for x, y, stuff in answer: # 넘겨받은 구조물 상태 (x좌표, y좌표, 기둥or보)
        if stuff == 0: # 기둥의 경우
            #'바닥 위' or '보의 양쪽 끝' or '또 다른 기둥' 
            if y == 0 or [x-1, y, 1] in answer or [x, y, 1] in answer or [x, y-1, 0] in answer:
                continue # 넘어가기 
            return False # 위의 조건을 충족하지 못하면 False 
        elif stuff == 1: # 보의 경우 
            #'한쪽 끝 부분이 기둥 위' or '양쪽 끝 부분이 다른 보와 동시 연결'
            if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer):
                continue
            return False
    return True

def solution(n, build_frame):
    answer = []
    for build in build_frame: # 주어지는 2차원 배열
        x, y, stuff, operation = build # x, y, 기둥or보, 삭제or설치
        if operation == 1: # 1 구조물 설치의 경우
            answer.append([x, y, stuff]) # 구조물의 상태(answer) 추가 
            if not check(answer): # check를 통해 반환값이 false 인 경우 answer에 삭제
                answer.remove([x, y, stuff])
        elif operation == 0: # 0 구조물 삭제의 걍우
            answer.remove([x, y, stuff]) # 구조물의 상태(answer) 삭제  
            if not check(answer): # check를 통해 반환값이 false 인 경우 answer에 추가  
                answer.append([x, y, stuff])
    answer.sort() # x 좌표 기준으로 오름차순 정렬
    return answer