from collections import deque
import sys

def bfs(v): #넓이 우선 탐색
  q = deque() #큐 만들기 -> 데큐로 하는것이 편함
  q.append(v) #처음 들어가는거 넣기
  visit_list[v] = 1 #방문 표시하기
  while q:
    v = q.popleft()
    print(v, end = " ")
    for i in range(1, n + 1):
      if visit_list[i] == 0 and graph[v][i] == 1: #방문을 안한것과 길이 있는 곳으로 가게 하기
        q.append(i)
        visit_list[i] = 1

def dfs(v): #깊이 우선 탐색
  visit_list2[v] = 1  #방문 표시 하기
  print(v, end = " ")
  for i in range(1, n + 1): #방문을 안한것과 길이 있는 곳으로 가게 하기
    if visit_list2[i] == 0 and graph[v][i] == 1:
      dfs(i)

n, m, v = map(int, sys.stdin.readline().split())  #정점,간선,시작번호 읽기

graph = [[0] * (n + 1) for _ in range(n + 1)] #간선 그래프
visit_list = [0] * (n + 1)  #방문 리스트
visit_list2 = [0] * (n + 1) #방문 리스트

for _ in range(m):
  a, b = map(int, sys.stdin.readline().split())
  graph[a][b] = graph[b][a] = 1 #간선 그래프 이어주기

dfs(v)
print()
bfs(v)