from collections import deque
def solution(maps):
    answer = 0 #0벽, 1길
    queue = deque([[0,0]])
    n = len(maps)
    m = len(maps[0])
    d = [(1,0),(-1,0),(0,1),(0,-1)] #방향 아래,위,오른쪽,왼쪽
    while queue:
        x,y = queue.popleft()
        
        for dx,dy in d:
            xx = x+dx
            yy = y+dy
            if 0<=xx<n and 0<=yy<m and maps[xx][yy]==1:
                queue.append([xx,yy])
                maps[xx][yy] = maps[x][y]+1
    if maps[n-1][m-1]!=1:
        return maps[n-1][m-1]
    else:
        return -1
