def solution(n, computers):
    answer = 0 #네트워크의 개수를 저장할 변수
    bfs = [] #탐색을 위한 큐
    visited = [0]*n # 방문한 노드를 체크해둘 리스트

    while 0 in visited: # 방문을 다할때 가지 반복
        x = visited.index(0) #방문 안한 노드 방문
        bfs.append(x) #큐에 추가
        visited[x] = 1  #방문 했다고 바꾸기
        
        while bfs:
            node = bfs.pop(0) #방문
            visited[node] = 1   #방문 확인
            for i in range(n): # 인접한 노드 방문하기 위해 반복문 수행
                if visited[i] == 0 and computers[node][i] == 1: # 인접 노드면서 방문된 적이 없는 경우 실행
                    bfs.append(i)
                    visited[i] = 1
        answer += 1
    return answer
