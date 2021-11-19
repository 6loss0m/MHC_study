def solution(triangle):
    for row in range(1, len(triangle)):
        for idx in range(row + 1):
            if idx == 0:
                triangle[row][idx] += triangle[row-1][idx]
            elif idx == row:
                triangle[row][idx] += triangle[row-1][-1]
            else:
                triangle[row][idx] += max(triangle[row-1][idx-1], triangle[row-1][idx])
    return max(triangle[-1])
# 선형 for문 이중이므로 O(n^2)인거 같습니다. 
