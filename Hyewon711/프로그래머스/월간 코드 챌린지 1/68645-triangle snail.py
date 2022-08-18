# 68645 - 삼각 달팽이

def solution(n):
    arr = [[0 for _ in range(i)] for i in range(1, n+1)]
    x, y, num = -1, 0, 1
    for i in range(n):
        for _ in range(i, n):
            if i % 3 == 0: # ↓
                x += 1
            elif i % 3 == 1: # →
                y += 1
            else: # ↖
                x -= 1
                y -= 1
            arr[x][y] = num
            num += 1
    answer = []
    for l in arr:
        answer += l
    return answer