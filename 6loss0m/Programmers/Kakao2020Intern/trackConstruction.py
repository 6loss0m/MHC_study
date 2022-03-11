from collections import deque


def solution(board):
    n = len(board)
    answer = int(1e9)
    print(answer)
    dp = [[int(1e9) for _ in range(n)] for _ in range(n)]
    # 현재 지나간 길을 확인하기 위한 idx 추가
    directions = [(-1, 0, 0), (0, 1, 1), (1, 0, 2), (0, -1, 3)]
    # i, j, cost, direction
    q = deque([(0, 0, 0, -1)])
    while q:
        i, j, cost, dir_idx = q.popleft()
        # 정답 범위이고, 현재 cost가 더 적을 때 값 할당
        if (i, j) == (n - 1, n - 1) and answer > cost:
            answer = cost
        for direction in directions:
            # 다음 값 셋팅
            next_i = i + direction[0]
            next_j = j + direction[1]
            add_cost = 1 if dir_idx == direction[2] or dir_idx == -1 else 6
            # 현재 값 판단할 지 여부
            if not (0 <= next_i < n and 0 <= next_j < n) or board[next_i][next_j] == 1:
                continue
            if dp[next_i][next_j] < cost + add_cost - 4:
                continue
            # dp에 값 설정 및 큐에 추가
            dp[next_i][next_j] = cost + add_cost
            q.append((next_i, next_j, cost + add_cost, direction[2]))
    return answer * 100