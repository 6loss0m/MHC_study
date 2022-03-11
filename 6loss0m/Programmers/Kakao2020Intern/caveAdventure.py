from collections import defaultdict
def solution(n, path, order):
    before = defaultdict(int)
    after = defaultdict(int)
    nodes = defaultdict(list)

    for i in range(len(path)):
        v1, v2 = path[i][0], path[i][1]
        nodes[v1].append(v2)
        nodes[v2].append(v1)
    
    for i in range(len(order)):
        if order[i][1] == 0:
            return False
        before[order[i][1]] = order[i][0]
    
    stack = [0]
    visited = [False]*n
    
    ###시작
    while stack:
        tmp_node = stack.pop()
        if tmp_node in before and not visited[before[tmp_node]]:
            after[before[tmp_node]] = tmp_node
            continue
        
        visited[tmp_node] = True
        for adj in nodes[tmp_node]:
            if not visited[adj]:
                stack.append(adj)
        
        if tmp_node in after:
            stack.append(after[tmp_node])
    
    return True if False not in visited else False