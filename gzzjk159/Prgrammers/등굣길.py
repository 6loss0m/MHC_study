def solution(m, n, puddles):
    answer = [[0]*(m+1) for _ in range(n+1)]
    answer[1][1] = 1
    for i in range(1, n+1):
        for j in range(1, m+1):
            if i==1 and j==1:
                continue
            if [j,i] in puddles:
                answer[i][j] = 0
            else:
                answer[i][j] = answer[i-1][j] + answer[i][j-1]
    return answer[n][m] % 1000000007
