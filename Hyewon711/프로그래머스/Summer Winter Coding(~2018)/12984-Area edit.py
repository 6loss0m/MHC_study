from itertools import chain

def solution(land, P, Q):
    # 일렬로 세우기
    line = list(chain.from_iterable(land))
    line.sort()
    # print(line)
    n = len(line)

    # 가장 낮은 층으로 편집 (무조건 0이 아니라 가지고 있는 층중에 맨 밑)
    # 가장 낮은 층은 지형이 다 있으므로 그 위의 블록을 모두 제거하면 된다.
    cost = (sum(line) - line[0] * n) * Q
    answer = cost

    # 한층씩 쌓기
    for i in range(1, n):
        if line[i] != line[i - 1]:
            # print(f'cost: {cost}, line[i-1]: {line[i - 1]}, line[i]: {line[i]} ')
            cost = cost + ((line[i] - line[i - 1]) * i * P) - ((line[i] - line[i - 1]) * (n - i) * Q)
            if answer < cost:  # 시간 단축 - 변곡점
                break
            answer = min(answer, cost)
    return answer