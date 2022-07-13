# 49994 - 방문 길이

def solution(dirs):
    answer = 0
    s = set()
    # U 상 D 하 L 좌 R 우 좌표
    d = {"U": [0, 1], "D": [0, -1], "L": [-1, 0], "R": [1, 0]}

    x, y = 0, 0 # 초기 위치 0,0
    for dir in dirs: # 주어진 dirs로 반복
        nx, ny = x + d[dir][0], y + d[dir][1] # 이동할 다음 좌표 nx, ny
        if -5 <= nx <= 5 and -5 <= ny <= 5: # 좌표평면의 경계를 넘어가면 if문을 통과하지 못한다.
            move1 = (x, y, nx, ny) # # 현재 위치 -> 이동 후 위치
            move2 = (nx, ny, x, y) # 이동 후 위치 -> 현재 위치
            # A에서 B로 이동할 때 set에 (A, B), (B, A)가 존재하는지 확인 => 이미 지나온 경로는 거리로 추가하지 않기에 확인이 필요
            if move1 not in s: # 만약 set에 저장되어 있지 않다면?
                # 처음 방문하는 길이면 answer를 1 증가시키고 set에 (A, B), (B, A)를 추가
                s.add(move1)
                s.add(move2)
                answer += 1 # 길이 +1
            x, y = nx, ny # 현재 좌표 갱신
    return answer