# BOJ 1931 - 회의실 배정
# https://www.youtube.com/watch?time_continue=865&v=7noZLdfHIMQ&feature=emb_title
# 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
# 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.

n = int(input())
time = []

for i in range(n) :
    start, end = map(int, input().split())
    time.append([start, end])
time.sort(key = lambda x: (x[1], x[0])) # 끝나는 시간으로 먼저 정렬 -> 같은 경우 시작 기준 정렬
# O(nlogn)

last = 0
ans = 0
for i, j in time :
    if i >= last:
        ans += 1
        last = j
print(ans)