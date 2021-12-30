from collections import deque
def solution(maps):
    answer = 0 #0벽, 1길
    queue = deque([[0,0]]) # 현재 [[0,0]]
    n = len(maps) # 세로
    m = len(maps[0]) # 가로
    d = [(1,0),(-1,0),(0,1),(0,-1)] # 아래, 위, 오른쪽, 왼쪽
    while queue:
        x,y = queue.popleft()
        for dx,dy in d:
            xx = x+dx
            yy = y+dy
            # 가로, 세로를 넘어가지 않고 길(1)인 상태일 경우
            if 0<=xx<n and 0<=yy<m and maps[xx][yy]==1:
                print(xx,yy)
                queue.append([xx,yy])
                maps[xx][yy] = maps[x][y]+1
    # 도착했을 때
    if maps[n-1][m-1]!=1:
        return maps[n-1][m-1]
    # 도착 못했을 때
    else:
        return -1