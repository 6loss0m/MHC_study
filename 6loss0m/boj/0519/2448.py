# 별찍기 - 11
def print_star(x, y, n):
    if n == 3:
        ans[x][y] = '*'
        ans[x+1][y-1] = ans[x+1][y+1] = '*'
        for i in range(-2, 3):
            ans[x+2][y+i] = '*'
    else:
        nn = n // 2
        print_star(x, y, nn)
        print_star(x+nn, y-nn, nn)
        print_star(x+nn, y+nn, nn)


N = int(input())
ans = [[' '] * 2 * N for _ in range(N)]
print_star(0, N-1, N)
for row in ans:
    print("".join(row))