# 92344 - 파괴되지 않은 건물
# 2차원 배열 요소를 하나씩 확인하다보면 시간 복잡도 O(N*M)이므로 누적합을 이용한다.
# 누적합을 기록하는 배열에 값을 저장한 후 마지막에 한번만 누적합을 계산하여 배열과 더하면 되므로 O(1) 시간복잡도
# https://kimjingo.tistory.com/155
def solution(board, skill):
    answer = 0
    tmp = [[0] * (len(board[0]) + 1) for _ in range(len(board) + 1)] # 누적합 기록을 위한 배열

    for type, r1, c1, r2, c2, degree in skill:
        # 누적합 기록, 부호에 주의할 것
        # type : 1 혹은 2 (1이면 적의 공격, 2면 회복)
        # True if 조건 else False
        tmp[r1][c1] += degree if type == 2 else -degree
        tmp[r1][c2 + 1] += -degree if type == 2 else degree
        tmp[r2 + 1][c1] += -degree if type == 2 else degree
        tmp[r2 + 1][c2 + 1] += degree if type == 2 else -degree

    # 행 기준 누적합
    for i in range(len(tmp) - 1):
        for j in range(len(tmp[0]) - 1):
            tmp[i][j + 1] += tmp[i][j]

    # 열 기준 누적합
    for j in range(len(tmp[0]) - 1):
        for i in range(len(tmp) - 1):
            tmp[i + 1][j] += tmp[i][j]

    # 기존 배열과 합함
    for i in range(len(board)):
        for j in range(len(board[i])):
            board[i][j] += tmp[i][j]
            # board에 값이 1이상인 경우 answer++
            if board[i][j] > 0: answer += 1

    return answer

