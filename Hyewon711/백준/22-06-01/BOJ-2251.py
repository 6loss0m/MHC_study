# BOJ 2251 - 물통

from collections import deque
import sys
input = sys.stdin.readline

def bfs(): # bfs 이용한 완전탐색
    while q:
        x, y, z = q.popleft() # queue의 맨 왼쪽 요소를 뽑아서 x, y, z에 저장
        if check[x][y] == 1: continue
        check[x][y] = 1 # 방문처리
        if x == 0:
            ans[z] = 1
        if x + y > a: # B->A로 옮기는데 A에서 넘쳐남
            q.append([a, y + x - a, z])
        else: # B->A로 옮기는데 A를 다 못채움
            q.append([y + x, 0, z])
        if x + z > a: # C->A로 옮기는데 A에서 넘쳐남
            q.append([a, y, z + x - a])
        else: # C->A로 옮기는데 A를 다 못채움
            q.append([z + x, y, 0])

        if x + y > b: # a->b로 옮기는데 b에서 넘쳐남
            q.append([x + y - b, b, z])
        else: # a->b로 옮기는데 b를 다 못채움
            q.append([0, x + y, z])
        if z + y > b: # C->B로 옮기는데 B에서 넘쳐남
            q.append([x, b, z + y - b])
        else: # C->B로 옮기는데 B를 다 못채움
            q.append([x, z + y, 0])

        if x + z > c: # A->C로 옮기는데 C에서 넘쳐남
            q.append([x + z - c, y, c])
        else: # A->C로 옮기는데 C를 다 못채움
            q.append([0, y, x + z])
        if y + z > c: # B->C로 옮기는데 C에서 넘쳐남
            q.append([x, y + z - c, c])
        else: # B->C로 옮기는데 C를 다 못채움
            q.append([x, 0, y + z])

a, b, c = map(int, input().split()) # 세 정수
check = [[0] * 201 for i in range(201)] # 물의 용량은 0 ~ 200리터
ans = [0 for i in range(201)]
q = deque()
q.append([0, 0, c]) # 첫 요소 0, 0, c
bfs()

for i in range(201):
    if ans[i]: # 값이 존재하는 경우 print
        print(i, end=" ")
# 첫 번째 물통(용량이 A인)이 비어 있을 때
# # 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램