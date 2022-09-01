# 17679 - 프렌즈 4 블록
# 2x2 형태로 붙어있는 경우
# 2x2 형태가 겹쳐있는 경우 (1개가 겹친 경우)에도 블록이 지워질 수 있다.
# 블록 매트릭스를 생성하여 스캔하고 제거해 나가는 작업을 반복하면서 더 이상 제거되지 않을 때 사라진 블록 자리의 수를 계산하면 됩니다.

# m 높이(문자열 개수) n 폭(문자열 길이) board 배치정보
def move_block(m, n, board): # 제거된 블록 떨어뜨리기
    for y in range(n):
        for x in range(m - 1, -1, -1): # 격자의 밑줄부터 탐색
            if board[x][y] == '': # 만약 빈 블록이라면?
                nx = x - 1 # 다음 좌표 이동
                while nx >= 0: # 모든 좌표를 돌 때까지
                    if board[nx][y] != '': # 빈 블록이 아니라면?
                        board[x][y] = board[nx][y] # 블록 이동
                        board[nx][y] = '' # 떨어뜨렸으므로 비우기
                        break
                    else: # 빈 블록이 아니면 다른 좌표로 넘어가기
                        nx -= 1
    return board # 보드 정보 리턴

def delete_block(m, n, board): # 블록 삭제
    delete = []

    for x in range(m - 1): # 문자열 개수만큼
        for y in range(n - 1): # 문자열 길이만큼
            if board[x][y] == '': # 만약 지워졌다면 넘어가기
                continue

            if board[x][y] == board[x][y + 1] and board[x][y] == board[x + 1][y] and board[x][y] == board[x + 1][y + 1]: # 만약 2*2가 같은 블록이라면?
                delete.append((x, y))
                delete.append((x + 1, y))
                delete.append((x, y + 1))
                delete.append((x + 1, y + 1)) # 삭제할 블록의 좌표 모두 추가

    delete = set(delete) # 집합 set 으로 저장

    for x, y in delete: # 만약 x, y가 delete에 저장된 집합에 있다면?
        board[x][y] = '' # 블록 지우기

    return board, len(delete) # 보드 정보와 지워진 집합 개수 리턴

def solution(m, n, board):
    answer = 0
    board = [list(x) for x in board] # 보드 정보 리스트

    board, count = delete_block(m, n, board) # 보드정보 board, 삭제된 블록의 개수 len(delete)
    answer += count # 지워진 블록의 개수

    while count > 0: # 카운트가 0이 될 때까지 탐색과 블록삭제를 반복
        move_block(m, n, board) # 블록 삭제 후, 떨어지도록 배치
        board, count = delete_block(m, n, board) # 보드정보와 삭제된 블록 개수
        answer += count

    return answer