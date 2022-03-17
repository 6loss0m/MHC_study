# 타일 채우기
# https://www.acmicpc.net/problem/2133
# 문제 : 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
# 입력 : 첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
# 출력 :첫째 줄에 경우의 수를 출력한다.

# 홀수 인 경우 무조건 0

n = int(input())
# n+1은 1이 입력될 경우 dp[2]가 인덱스를 초과하게 되므로
# n+2로 충분히 크게 만들어주자.
dp = [0] * (n+1)

if n % 2 == 1:
    print(0)
else:
    dp[2] = 3
    for i in range(4,n+1,2):
        dp[i] += dp[i-2] * 3
        for j in range(i-4,0,-2):
            dp[i] += dp[j] * 2
        dp[i] += 2
    print(dp[n])

# https://my-coding-notes.tistory.com/201