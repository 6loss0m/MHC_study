"""
    2304 - 창고 다각형
    수평 부분은 반드시 어떤 기둥의 윗면과 닿아야한다
    수직 부분은 반드시 어떤 기둥의 옆면과 닿아야한다
    이 말은 즉, 현재 위치보다 더 높은 기둥이 있는 경우엔 지붕을 더 높게 올린다.
    지붕의 어떤 부분도 오목하면 안되므로 낮은 기둥은 신경쓰지 않아도 된다.
    max값을 잘 활용하자

"""

n = int(input()) # 기둥의 개수
find_h = 0 # 가장 높은 기둥을 찾기 위한 변수
find_l = 0 # 가장 높은 기둥의 x좌표를 찾기 위한 변수
current = 0 # 현재위치
result = 0
column = [ 0 for _ in range(1001)] # 기둥정보

for _ in range (n) :
    l, h = map(int, input().split()) # 각 기둥의 왼쪽 면의 위치 L, 높이 H
    column[l] = h # 기둥 정보 column, x좌표에 높이를 저장
    if find_h < h : # 가장 높은 기둥을 찾기
        find_l = l
        find_h = h

for i in range(find_l+1): # 왼쪽부터 가장 높은 기둥까지 확인
    current = max(current, column[i])
    result += current

current = 0

for j in range(1000, find_l, -1) : # 오른쪽부터 가장 높은 기둥까지 확인
    current = max(current, column[j])
    result += current

# 가장 높은 기둥을 기준으로 양쪽에서 더해진 result 값이 정답이 된다.
print(result)
