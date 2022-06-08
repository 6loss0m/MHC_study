# 가장 가까운 두 점
import sys, random
input = sys.stdin.readline
n = int(input())
pl = [list(map(int,input().split())) for i in range(n)]

# x축 기준 정렬
pl.sort()

# 두 점 사이의 거리 계산 함수
def getDist(p1, p2):
    return (p1[0] - p2[0])**2 + (p1[1] - p2[1])**2

def dac(start,end):
    # 점 하나의 거리는 없으니 최대값 리턴
    if start == end:
        return float('inf')

    # 점이 두 개 남으면 사이의 거리 리턴
    if end - start == 1:
        return getDist(pl[start],pl[end])

    # 분할정복 실행
    mid = (start + end)//2
    minDist = min(dac(start, mid), dac(mid,end))

    # x축 기준으로 후보 점들을 찾는다.
    target_pl = []
    for i in range(start, end+1):
        if (pl[mid][0] - pl[i][0])**2 < minDist:
            target_pl.append(pl[i])

    # y축 기준 정렬
    target_pl.sort(key=lambda x: x[1])

    # y축 기준으로 후보 점들 사이의 거리 비교
    t = len(target_pl)
    for i in range(t-1):
        for j in range(i+1,t):
            if (target_pl[i][1] - target_pl[j][1])**2 < minDist:
                minDist = min(minDist, getDist(target_pl[i],target_pl[j]))
            else:
                break
                # 현재 후보 점이 다음 점과 최소 거리보다 멀다면 더 볼 필요가 없음.
                # 위 처리가 없으면 시간 초과 발생
    return minDist

print(dac(0,n-1))