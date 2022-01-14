# 정렬 문제 / 시간복잡도 O(n^2) / 이전문제와 달리 y축 기준 (좌표를 y좌표가 증가하는 순) 

n = int(input())
arr = []
for i in range(n):
    x, y = map(int, input().split())
    arr.append([y, x])
    
arr = sorted(arr)

for i in range(n):
    print(arr[i][1], arr[i][0])