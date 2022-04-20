# 골드바흐의 추측
from sys import stdin

# 에라토스테네스의 체
# (1) 전체 수 만큼 True의 리스트를 생성해준다.
# (2) 2부터 +1씩 해주면서 그 배수에 해당하는 값들을 False로 바꿔준다.

array = [True for i in range(1000001)]

for i in range(2, 1001):
    if array[i]:
        for k in range(i + i, 1000001, i):
            array[k] = False

# 요구하는 값만 출력하고 break
while True:
    n = int(stdin.readline())

    if n == 0: break

    for i in range(3, len(array)):
        if array[i] and array[n-i]:
            print(n, "=", i, "+", n-i)
            break