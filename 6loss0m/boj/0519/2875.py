# 대회 or 인턴
# [팀] 여2 남1
# N(여), M(남), K(반드시 참여)
import sys
N,M,K = map(int,sys.stdin.readline().split())
cnt = 0

# 팀구성
if N // 2 > M:
    cnt = cnt + M
    N = N - (M * 2)
    M = 0
else:
    cnt = cnt + (N//2)
    M = M - (N//2)
    N = 0

# 인턴쉽 인원 제외
if (N+M) < K:
    K = K - (N+M)
    cnt = (cnt*3 - K)//3

print(cnt)