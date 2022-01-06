#모든 방을 적어도 한번은 방문
#특정 방 방문 전에 먼저 방문해야하는 방 존재

def solution(n, path, order):
	
    #path 정보로 부터 인접 리스트를 구현한다.
    tree = [[] for _ in range(n)]
    for v1, v2 in path:
        tree[v1].append(v2)
        tree[v2].append(v1)
      
    #어떤 방 X에 가기 위해 들러야하는 방은 1개이거나 존재하지 않음
    #orders[i] : i번째 방을 방문하기 위해 이전에 방문해야하는 노드
    orders =[0 for i in range(n)]
    for pre, post in order:
        orders[post] = pre
    
    
    num_visit = 0
    
    visited = [False for i in range(n)]
    q = [0]
    
    #방문해야하는 노드 : key에 있는 노드를 들른 후 갈 수 있는 노드
    after ={}
    
    while q:
        here = q.pop(0)
        
        #현재 위치를 방문하기전에 들러야하는 정점이 존재하고 아직 그 정점을 방문하지 않았다면 체크해둔다.
        #orders[here] : here를 방문하기 위해 이전에 방문해야하는 정점
        if orders[here] and not visited[orders[here]]:
            after[orders[here]] = here
            continue
        
        #위 조건을 통과하면 방문 가능
        visited[here] = True
        num_visit +=1
    	
        #현재 위치와 연결되어 있는 점들을 q에 추가해준다.
        for there in tree[here]:
            if not visited[there]:     
                q.append(there)
        
        #지금 방문하는 곳이 after에 포함되어 있다면 이제 현재 위치를 방문해야 갈 수 있는 정점으로 
        #이동가능하므로 이동가능 한 정점을 q에 넣어준다.
        
        if here in after:
            q.append(after[here])
                    
    return n == num_visit