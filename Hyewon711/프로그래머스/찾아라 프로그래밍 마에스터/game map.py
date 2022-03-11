from collections import deque #BFS 미로탐색과 유사 / 시간복잡도 O(n^2)

def solution(maps):
    N = len(maps) #행
    M = len(maps[0]) #열

    dx,dy=[0,0,-1,1],[1,-1,0,0]  #상, 하, 좌, 우
    queue=deque([(0,0)])
    #1 = 지나갈 수 있는 길 0 = 지나갈 수 없는 길

    while queue:
        x,y = queue.popleft()

        #최단 경로로 온 경우
        if (x,y) == (N-1,M-1): 
               return maps[x][y] #칸의 개수의 최솟값

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            
            #maps[nx][ny]가 갈 수 있고 
            if 0 <= nx < N and 0 <= ny < M:
                #한번도 방문하지 않은 경우
                if maps[nx][ny] == 1:
                    maps[nx][ny]=maps[x][y]+1
                    queue.append((nx,ny))
    
    #상대 팀 진영에 도착할 수 없을 때
    return -1