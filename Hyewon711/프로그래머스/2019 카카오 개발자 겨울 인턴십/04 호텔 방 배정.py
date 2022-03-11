import sys
sys.setrecursionlimit(1500)
# 재귀를 사용해서 풀어야 하는 문제라면, 위 코드를 상단에 쓰는 것은 선택이 아닌 필수 
# 하지않는 경우 런타임 에러가 날 수 있음 ! 

# 방을 찾는 함수
def find_empty_room(x, rooms):
    # 현재 방넘버 x에 아무도 배정되지 않은 경우
    if x not in rooms:
        # 현재 방넘버 기준, 다음으로 빈 방 좌표를 저장한다.
        rooms[x] = x + 1
        # 현재 방넘버 x를 반환한다.
        return x
    # 아무도 배정받지 않은 방이 나올 때까지 함수를 시행한다.
    p = find_empty_room(rooms[x], rooms)
    rooms[x] = p + 1
    return p
    

def solution(k, room_number):
    # 해당 번호 기준, 그 번호보다 값이 크면서 빈 방의 좌표를 저장하는 dict
    rooms = dict()
    answer = []
    for each_room in room_number:
        empty_room = find_empty_room(each_room, rooms)
        answer.append(empty_room)
    return answer