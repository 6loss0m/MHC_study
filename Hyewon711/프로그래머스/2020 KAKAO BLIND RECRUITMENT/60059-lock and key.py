# 60059 - 자물쇠와 열쇠
import copy

def solution(key, lock):
    # check함수: nlock배열을 매개변수로 넘겨받아 nlock의 모든 칸이 1이면 True, 하나라도 1이 아니면 False 리턴해줌.
    def check(a):
        for line in a:
            for l in line:
                if l != 1:
                    return False
        return True

    # rotate함수: key리스트를 매개변수로 넘겨받아 2차원 배열 회전시킨다.
    def rotate(m, d):
        N = len(m)
        ret = [[0] * N for _ in range(N)]

        # d = 1 -> 시계방향으로 90도회전
        if d == 1:
            for r in range(N):
                for c in range(N):
                    ret[c][N-1-r] = m[r][c]
                    # d = 2 -> 시계방향으로 180도회전
        elif d == 2:
            for r in range(N):
                for c in range(N):
                    ret[N-1-r][N-1-c] = m[r][c]
        # d = 3 -> 시계방향으로 270도회전
        elif d == 3:
            for r in range(N):
                for c in range(N):
                    ret[N-1-c][r] = m[r][c]
        # d = 0 -> 그대로
        else:
            for r in range(N):
                for c in range(N):
                    ret[r][c] = m[r][c]

        return ret

    N = len(key)
    M = len(lock)
    nkey = copy.deepcopy(key)
    # key의 끝부분 한칸이 겹쳐서 정답이 될 수 있으므로 lock의 범위보다 더 크게 범위 잡음
    for i in range(-N, M+N):
        for j in range(-N, M+N):
            for r in range(4):
                # key를 90도씩 회전시키면서 lock의 모든 칸에 대입해본다.
                nlock = copy.deepcopy(lock)
                nkey = rotate(nkey, r)

                # 0부터 nkey의 범위까지 반복문을 돌며 (i+x, j+y)가 lock범위 내에 존재한다면
                # nlock[i+x][j+y]에 nkey[x][y]를 더해줌.
                # 범위 밖은 신경쓰지 않는다고 했으므로 lock범위 안에 있을때만 신경써주면 됨.
                for x in range(len(nkey)):
                    for y in range(len(nkey)):
                        if 0 <= i + x < M and 0 <= j + y < M:
                            nlock[i+x][j+y] += nkey[x][y]

                # check(nlock)이 True이면 return Ture, False이면 contiune를 만나 nkey를 90도 더 회전시킴
                if check(nlock):
                    return True
                else:
                    continue
    return False