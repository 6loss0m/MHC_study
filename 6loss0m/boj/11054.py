# 가장 긴 바이토닉 부분 수열
# k번쨰 중심으로 점점 작아지는 수열
# 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이 구하기
# 10
# 1 5 2 1 4 3 4 5 2 1
# 반례 : https://www.acmicpc.net/board/view/56223

# 문제풀이
# 리스트의 i 번째까지 LIS(Longest Increasing Sequence)를 찾는다.
# 역방향으로 N-1부터 i까지 LIS를 찾는다.
# 두 개의 길이를 더하고 최대가 되는 i (0<=i<N) 값을 반환한다.

# 주의사항 : dp[i]와 dp2[i]를 더했을 때, i를 두 번 더하게 됨으로 1을 마지막에 빼줘야 한다.
#
N = int(input())
seq = list(map(int, input().strip().split()))
# strip() : 인자로 전달된 문자를 String의 왼쪽과 오른쪽에서 제거합니다.
# -> 그냥 공백제거 하려는듯? 없어도 문제 x
dp = [0 for i in range(N)] #정방향
rdp = [0 for i in range(N)] #역방향
# LIS : 최장 증가 부분 수열

# 정방향으로 LIS를 찾는다.
for i in range(N):
    for j in range(i):
        if seq[i]>seq[j] and dp[i]<dp[j]:
            dp[i] = dp[j]
    dp[i] +=1


# 역방향으로 LIS를 찾는다.
for i in range(N-1,-1,-1):
    for j in range(N-1, i, -1):
        if seq[i]>seq[j] and rdp[i]<rdp[j]:
            rdp[i] = rdp[j]
    rdp[i] +=1

#print(dp)
#print(dp2)

MAX = 0
for i in range(N):
    if dp[i]+rdp[i] > MAX:
        MAX = dp[i]+rdp[i]
print(MAX-1)


# https://jrc-park.tistory.com/103