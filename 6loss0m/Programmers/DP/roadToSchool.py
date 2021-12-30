def solution(m, n, puddles):
    answer = [[0]*(m+1) for _ in range(n+1)]
    answer[1][1] = 1 # 집이 있는 좌표
    for i in range(1, n+1):
        for j in range(1, m+1):
            # 집인 경우
            if i == 1 and j == 1:
                continue
            # 웅덩이 인 경우
            elif [j,i] in puddles:
                answer[i][j] = 0
            # 그외의 경우
            # 해당 지역으로 이동하는 경우는 위에서 오거나, 왼쪽에서 와야하기
            # 때문에 그 두가지의 경우의 수를 더해준다.
            else:
                answer[i][j] = answer[i][j-1] + answer[i-1][j]
    return answer[n][m] % 1000000007