# 92343 - 양과 늑대
# 늑대의 수가 양과 같거나 많아지면 양을 잡아먹는다.

def dfs(idx, sheep, wolf, possible): # 현재 정점, 양, 늑대, 이동 가능 정점
    global g_info, answer, graph
    if g_info[idx] == 0: # 0인 경우 양
        sheep += 1
        answer = max(answer, sheep) # 양의 수가 최대인지 확인 후 갱신
    else: # 1인경우 늑대
        wolf += 1

    if wolf >= sheep: # 늑대의 수가 같거나 더 많으면 return
        return

    possible.extend(graph[idx])
    # 현재 정점의 자식 노드를 이동 가능한 정점에 넣는다.
    # append : 요소 하나 추가
    # extend : 모든 요소를 리스트에 추가
    for p in possible: # 이동 가능 정점 탐색, DFS로 재귀하며 진행
        dfs(p, sheep, wolf, [i for i in possible if i != p])
        # i for i in possible if i != p] ->
        # 만약 해당 정점을 선택할 경우 방문한 상태가 되므로
        # 이동 가능한 정점에서는 제거, DFS 함수에 넣는다.

def solution(info, edges):
    global answer, g_info, visited, graph
    answer = 0
    g_info = info
    n = len(info)
    graph = [[] for _ in range(n)] # info의 길이만큼 그래프 그리기

    for a, b in edges:
        graph[a].append(b) # 서로 연결된 두 노드 연결
        # a : 부모 노드 번호, b : 자식 노드 번호
        # 단방향 인접리스트(그래프를 거꾸로 올라가지 않아도 0K), edge 정보 저장
        # 이미 지나간 정점은 재방문해도 상관없음, 이미 방문한 정점이 아닌 다음 차례에 이동 가능한 정점을 담아야한다.

    dfs(0, 0, 0, []) # DFS 돌기
    return answer