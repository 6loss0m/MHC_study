from collections import deque
def solution(board):
    n = len(board)
    answer = int(1e9)
    dp = [[int(1e9) for _ in range(n)] for _ in range(n)]
    directions = [(-1, 0, 0), (0, 1, 1), (1, 0, 2), (0, -1, 3)]
    q = deque([(0, 0, 0, -1)])
    while q:
        i, j, cost, dir_idx = q.popleft()
        if (i, j) == (n - 1, n - 1) and answer > cost:
            answer = cost
        for direction in directions:
            next_i = i + direction[0]
            next_j = j + direction[1]
            add_cost = 100 if dir_idx == direction[2] or dir_idx == -1 else 600
            if not (0 <= next_i < n and 0 <= next_j < n) or board[next_i][next_j] == 1:
                continue
            if dp[next_i][next_j] < cost + add_cost - 400:
                continue
            dp[next_i][next_j] = cost + add_cost
            q.append((next_i, next_j, cost + add_cost, direction[2]))
    return answer