# BOJ 1987 - 알파벳
# 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데,
# 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
# 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

import sys
input = sys.stdin.readline
R, C = map(int, input().split())
arr = []
for _ in range(R):
    arr.append(list(input().strip()))
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
result = 0

def dfs():
    global result
    q = set([(0, 0, arr[0][0])]) # set 자료형으로 값을 확인, 중복되는 값은 제외
    # 리스트가 아닌 집합 자료형 set으로 기록 (인덱스X, 순서X)
    while q:
        x, y, hist = q.pop() # 초기 hist에는 보드의 0,0에 위치한 대문자 알파벳이 저장되어있다.
        result = max(result, len(hist)) # hist 길이와 result에 저장된 값 중 최대값 저장
        for k in range(4): # 4방향
            nx = x + dx[k]
            ny = y + dy[k]
            # 좌표가 인덱스 범위 내인 경우
            if 0 <= nx < R and 0 <= ny < C:
                # 새로운 좌표에 있는 알파벳이 hist에 있지않은 경우
                if arr[nx][ny] not in hist:
                    q.add((nx, ny, hist+arr[nx][ny])) # q에 추가한다.

dfs()
print(result)