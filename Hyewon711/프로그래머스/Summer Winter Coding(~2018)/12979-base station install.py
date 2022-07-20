# 12979 - 기지국 설치
# n의 크기가 2억 이하의 자연수? -> 이분탐색인가?
# 이분탐색으로 접근하기엔 최소 최대값을 굳이 구하지 않아도 될 것 같은데 ..
# 기지국의 영향을 받지 않는 곳의 크기를 구하고 기지국이 영향을 주는 범위만큼 나눈다.
# 기지국의 영향을 받지않는 곳을 봤을 때 (2 * w + 1)로 나누면 필요한 기지국의 개수를 알 수 있다.

import math
def solution(n, stations, w):
    answer = 0
    distance = []  # 기지국의 범위 left, right를 저장할 리스트

    # 설치된 기지국 사이에 전파가 닿지 않는 거리를 저장한다
    for i in range(1, len(stations)): # 1부터 station 요소 개수까지
        distance.append((stations[i]-w-1) - (stations[i-1]+w))

    # 맨 앞 기지국에서 첫 번째 아파트 사이에 전파가 닿지 않는 거리와
    # 맨 뒤 기지국에서 마지막 아파트 사이에 전파가 닿지 않는 거리를 저장
    distance.append(stations[0]-w-1)
    distance.append(n - (stations[-1]+w)) # stations[-1]은 맨 마지막 요소

    for i in distance:
        # 닿지 않는 거리가 0 이하일 경우 전파범위에 해당되므로 continue
        if i <= 0 :
            continue
        # 닿지 않는 거리에 설치할 수 있는 최소개수를 더해준다.
        # ceil는 올림 함수이다. (거리 / 기지국범위) 를 계산하면
        answer += math.ceil(i / ((w*2) +1))

    return answer