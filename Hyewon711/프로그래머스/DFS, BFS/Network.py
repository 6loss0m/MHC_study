# BFS - 조건문 / 큐 / 시간복잡도 : O(N*N)

def solution(n, computers):
    answer = 0
    bfs = []
    visited = [0]*n

    while 0 in visited:
        bfs.append(visited.index(0))
        while bfs:
            node = bfs.pop(0)
            visited[node] = 1
            for i in range(n):
                if visited[i] == 0 and computers[node][i] == 1:
                    bfs.append(i)
        answer += 1
    return answer