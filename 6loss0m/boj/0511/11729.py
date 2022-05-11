# 하노이의 탑
# n개의 원판이 있을때, n - 1개의 원판 즉, 맨 밑의 원판을 제외하고 나머지 원판들을
# 1번에서 2번으로 옮긴 뒤, 맨 밑의 원판을 1번에서 3번으로 옮긴다.
# 그리고 n - 1개의 원판들을 다시 2번에서 3번으로 옮긴다.
n = int(input())
def hanoi(n, a, b, c):
    if n == 1:
        print(a, c)
    else:
        hanoi(n - 1, a, c, b)
        print(a, c)
        hanoi(n - 1, b, a, c)
sum = 2 ** n -1
print(sum)
hanoi(n, 1, 2, 3)