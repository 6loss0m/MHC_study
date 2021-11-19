# BFS

**너비 우선 탐색(Breadth First Search)**은 탐색을 할 때 너비를 우선으로 하여 탐색을 수행하는 탐색알고리즘 입니다.

너비 우선 탐색은 '최단 경로'를 찾아 준다는 점에서 최단 길이를 보장해야 할 때 많이 사용합니다.

준비물은 **큐(Queue)**입니다.

## BFS 동작 알고리즘

1. 큐에서 하나의 노드를 꺼냅니다.
2. 해당 노드에서 연결된 노드 중 방문하지 않은 노드를 방문하고, 차례대로 큐에 삽입합니다.

위 1번과 2번을 반복하면 됩니다.

![bfs](https://user-images.githubusercontent.com/31503178/142599368-0d38acb8-eaf6-4ef5-a9e9-d0806cc2ff03.png)

동작 방식을 간단히 설명해 보겠습니다.

먼저, 1번노드를 큐에 넣고 방문 처리를 하고 시작하게됩니다.

1. pop(1번노드) → 큐 상태: 0
2. 1번노드의 인접 노드 중 방문하지않은 노드를 방문하고, 큐에 삽입합니다. → 큐 상태: 2,3
3. pop(2번 노드) → 큐 상태 : 3
4. 2번노드의 인접 노드 중 방문하지않은 노드를 방문하고, 큐에 삽입합니다. → 큐 상태: 3,4,5
5. pop(3번 노드) → 큐 상태: 4,5
6. 3번노드의 인접 노드 중 방문하지않은 노드를 방문하고, 큐에 삽입합니다. → 큐 상태: 4,5,6,7
7. pop(4번 노드) → 큐상태 : 5,6,7

......

...

.

방문 순서 : 1-2-3-4-5-6-7

## BFS 핵심요소

BFS의 핵심요소는 탐색을 시작한 노드와 가까운 노드부터 탐색을 시작하여 점점 먼 노드를 탐색합니다. 위 그림에서 예를 들면 거리가 1인 2,3노드를 모두 탐색한 뒤, 거리가 2인 4,5,6,7 을 탐색합니다.

그러기때문에 **BFS탐색은 최단거리를 항상 보장**할 수있습니다. 

## BFS 코드 in JAVA

```java
public class BFS {
    static LinkedList<Integer>[] linkedList;
    static Boolean[] visit;
    public static void main(String args[]){
        linkedList = new LinkedList[8];
        visit = new Boolean[8];
        Arrays.fill(visit,false);
        for(int i=0; i< linkedList.length; i++){
            linkedList[i]= new LinkedList<>();
        }

        linkedList[1].add(2);
        linkedList[2].add(1);

        linkedList[1].add(3);
        linkedList[3].add(1);

        linkedList[2].add(3);
        linkedList[3].add(2);

        linkedList[2].add(4);
        linkedList[4].add(2);

        linkedList[2].add(5);
        linkedList[5].add(2);

        linkedList[3].add(6);
        linkedList[6].add(3);

        linkedList[3].add(7);
        linkedList[7].add(3);

        linkedList[4].add(5);
        linkedList[5].add(4);

        linkedList[6].add(7);
        linkedList[7].add(6);
        bfs(1);

    }
    static public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);             // 탐색을 시작할 노드를 넣고 시작.
        visit[start] = true;      // 방문 하였기때문에 방문 체크
        
        while(!q.isEmpty()){
            int num = q.poll();         // 노드 pop
            System.out.print(num+" ");
            
            for(LinkedList<Integer> list : linkedList){   // 노드의 인접 노드 탐색
                for(int i=0;i<list.size(); i++){
                    int n = list.get(i);
                    if(!visit[n]){
                        visit[n]=true;
                        q.add(n);
                    }
                }
            }
        }

    }
}
```
<details markdown="1">
<summary> 인접 행렬? 인접 리스트? </summary>
  
## 인접 행렬
    
### 1) 정의
    
인접 행렬은 그래프의 연결 관계를 이차원 배열로 나타내는 방식입니다. 인접 행렬을 adj[][] 라고 합낟면 adj[i][j] 에 대해서 다음과 같이 정의 할 수 있습니다.
    
> **adj[i][j]** : 노드 i에서 노드 j로가는 간선이 있으면 1, 아니면 0
> 
    
### 2) 장단점
    
인접 행렬의 **장점**
    
1. 구현이 쉽다.
2. 노드 i와 노드 j가 연결되어 있는지 확인하고 싶을 때, adj[i][j]가 1인지 0인지만 확인 시간 복잡도: **O(1)**
    
인접 행렬의 **단점**
    
1. 한 노드에 연결된 모든 노드를 방문하려면, adj[i][1] 부터 adj[i][V] 까지 확인 시간복잡도: **O(V) (V는 노드의 수)**
    
## 인접 리스트
    
### 1)정의
    
인접 리스트는 그래프의 연결 관계를 vector의 배열(vector<int> adj[])로 나타내는 방식입니다. 이 때, vector<int>에는 노드의 번호가 직접 저장됩니다. 인접 리스트는 adj[i]를 다음과 같이 정의할 수 있습니다.
    
> **adj[i]** : 노드 i에 연결된 노드들을 원소로 갖는 vector
> 
    
### 2) 장단점
    
인접 리스트의 **장점**

1. 실제로 연결된 노드들에 대한 정보만 저장하기 때문에, 벡터들의 원소의 개수의 합과 간선의 개수가 같다는 점. 즉, **간선의 개수에 비례하는 메모리만 차지.**
2. 한 노드에 연결 된 모든 노드를 방문하려면, 시간복잡도: **O(E) (E는 간선의 수)**
    
인접 리스트의 **단점**
    
1. 노드 i와 j가 연결되어 있는지 확인하고 싶을때, adj[i][0] 부터 adj[i][adj[i].size()-1] 까지 확인 해야 함. 시간 복잡도: **O(V)**
    
## DFS & BFS 에서의 시간 복잡도

- **인접행렬**에서의 시간 복잡도
      - 모든 정점을 다 찾아봐야 하기 때문에 dfs(x)의 시간 복잡도는 **O(V)**
      - dfs(x)가 V번 호출되어야 하므로 전체 dfs알고리즘의 시간복잡도는 **O(V*V)=O(V^2)**
- **인접리스트**에서의 시간 복잡도
      - 인접행렬과 마찬가지로 dfs(x)는 V번 호출
      - dfs(x)의 시간복잡도는 **O(V+E)**
          - 인접리스트에서 dfs가 호출되는 방법은 모든 정점을 다 찾는 인접행렬의 탐색 방법과 다릅니다.
          - 또한 a[x].size()는 전체 간선의 개수가 아니라, 한 정점과 연결된 간선의 개수이기 때문에 dfs(x)의 시간복잡도는 O(E)가 아님을 주의해야 합니다.
    
> **DFS & BFS 모두 시간복잡도는 같습니다.**


</details>
