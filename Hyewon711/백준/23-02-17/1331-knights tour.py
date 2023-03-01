"""
    1331 - 나이트 투어
    나이트 투어는 체스판에서 나이트가 모든 칸을 정확히 1번씩 방문,
    마지막으로 방문한 칸에서 시작점으로 돌아올 수 있는 경로이다.

    6 x 6 체스판, 좌표는 x축 A~F / y축 1~6
    입력은 모든 칸을 순서없이 나열한 것이기에 이동 가능 여부 확인만 하고
    모든 칸을 투어했는지 확인할 필요가 없다.

    나이트 이동 가능한 좌표 (1,2),(1,-2),(2,1),(2,-1),(-1,2),(-1,-2),(-2,1),(-2,-1) 8가지
    이동 가능 좌표를 충족해야하고 and 한 번 방문한 곳은 다시 방문하지 않고 and 처음위치로 다시 돌아와야한다.
"""

visited = [] # 방문했던 곳을 담을 리스트
ans = "Valid"

# 36칸의 체스판
for i in range(36): # 0~35 (36칸)

    if i == 0: # 처음 좌표 저장
        start = input()
        pre = start

    elif i < 35: # 좌표 이동을 할 것, 위에 언급한 조건 중 나이트 이동경로, 최초방문 확인
        now = input()
        if ((abs(ord(pre[0]) - ord(now[0])) ==1 and abs(int(pre[1])-int(now[1])) == 2) or (abs(ord(pre[0]) - ord(now[0])) ==2 and abs(int(pre[1])-int(now[1])) == 1)) and now not in visited:
            pass # 나이트 이동경로와 최초방문을 충족한다면
        else: # 충족 X
            ans = "Invalid"
            break
        visited.append(now) # 방문리스트에 삽입
        pre = now

    else: # i = 35일때, 마지막으로 방문한 칸에서 시작점으로 돌아올 수 있는지 확인
        now = input()
        if ((abs(ord(now[0]) - ord(start[0])) ==1 and abs(int(now[1])-int(start[1])) == 2) or (abs(ord(now[0]) - ord(start[0])) ==2 and abs(int(now[1])-int(start[1])) == 1)) and now not in visited:
            pass # 나이트 이동경로와 최초방문을 충족한다면
        else: # 충족 X
            ans = "Invalid"
            break

print(ans)