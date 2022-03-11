import sys
sys.setrecursionlimit(10000) # 임의로 재귀 허용 깊이 설정

def solution(k, room_number):
    rooms = dict() # {방번호: 바로 다음 빈방 번호}
    for num in room_number:
        chk_in = find_emptyroom(num,rooms)
    return list(rooms.keys())

def find_emptyroom(chk, rooms): # 재귀함수
    print(chk,rooms)
    if chk not in rooms.keys(): # 빈 방이면
        rooms[chk] = chk+1 # rooms에 새 노드 추가
        return chk # 요청한 방
    empty = find_emptyroom(rooms[chk], rooms) # 재귀함수 호출
    rooms[chk] = empty+1 # (배정된 방+1)을 부모노드로 변경
    return empty # 새로 찾은 빈 방
'''
def solution(k, room_number):
    answer = []
    for i in room_number :
        # 비어 있는 경우
        if i not in answer :
            answer.append(i)
        # 비어 있지 않은 경우
        else :
            for j in range(i,k) :
                if j not in answer :
                    answer.append(j)
                    break
    return answer
'''