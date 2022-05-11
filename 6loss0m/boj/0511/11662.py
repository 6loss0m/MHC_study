# 민호와 강호
def threeSearch(left, right):
    while abs(right - left) > 1e-9:
        left3 = (2 * left + right) / 3
        right3 = (left + 2 * right) / 3
        if dist(left3) > dist(right3):
            left = left3
        else:
            right = right3
    return dist(left)


def dist(t):
    mx = ax * t + bx * (1 - t)
    my = ay * t + by * (1 - t)
    kx = cx * t + dx * (1 - t)
    ky = cy * t + dy * (1 - t)
    return ((kx - mx) ** 2 + (ky - my) ** 2) ** 0.5


ax, ay, bx, by, cx, cy, dx, dy = map(int, input().split())
print("%.16f" % threeSearch(0, 1))  # 비율을 1을 기준으로 했으므로

# https://goodsosbva.tistory.com/m/37?category=454008