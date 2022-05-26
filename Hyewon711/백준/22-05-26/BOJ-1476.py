# BOJ 1476 - 날짜 계산
import sys
input = sys.stdin.readline

E, S, M = map(int, input().split())
# 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
ans = 1

while True  :
    if ( ( ans - E ) % 15 == 0 and ( ans - S ) % 28 == 0 and ( ans - M ) % 19 == 0 ) :
        # e = 16, s = 29, m = 20 일때마다 1로 초기화되므로, 각각 16, 29, 20가 되는 경우는 불가
        print(ans)
        break
    ans = ans + 1
# 표시되는 가장 빠른 연도를 출력
# 1부터 증가하면서 반복하면 가장 처음 세 수가 동일할 때가 가장 빠른 연도

