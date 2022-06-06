# BOJ 10819 - 차이를 최대로
# 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다. (음수가 입력될 수 있다.)
from itertools import permutations
import sys
input = sys.stdin.readline

n = int(input()) # 3 <= n <= 8 이므로 범위가 작다.
a = list(map(int, input().split()))

ans = 0
# 모든 조합 경우의 수를 통해 차를 구하고 최댓값을 출력
# 조합을 이룰 땐 순열함수 permutations 를 이용
for i in permutations(a) : # 모든 조합을 반복
    sum = 0
    for j in range (n-1) :
        sum += abs(i[j] - i[j+1]) # abs는 파이썬에서 제공하는 절댓값 함수
    ans = max(ans, sum)
print(ans)