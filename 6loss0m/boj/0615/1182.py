# 부분수열의 합
# N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서
# 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
from itertools import combinations
from sys import stdin
N, S = map(int, stdin.readline().split())
num = list(map(int,stdin.readline().split()))
item = []
cnt = 0

# 경우의 수 구하기
for i in range(1,len(num)+1):
    item.append(list(combinations(num, i)))
# 합 비교
for i in item:
    for j in i:
        if sum(j) == S:
            cnt += 1

print(cnt)