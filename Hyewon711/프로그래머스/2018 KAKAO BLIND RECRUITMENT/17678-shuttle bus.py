# 17678 - 셔틀버스
# 오전 9시 / 셔틀 운행 n회 / 총 t분 간격 / m명 정원 / 대기열 도착 시각 timetable

# case1) 마지막 버스에 정원이 다 찼는가? -> 마지막으로 탄 한명을 잡아댕긴다.
# case2) 마지막 버스에 정원이 다 안찼는가? -> 천천히 가준다. 버스시간에 맞춰준다.

# HH:MM의 시간을 모두 분으로 변환하여 푸는 것이 좋음
# 09:10 -> 9*60 + 10 = 550

def solution(n, t, m, timetable):
    answer = 0

    timetable = [int(time[:2])*60+int(time[3:]) for time in timetable]
    # time[:2]는 시, time[3:]는 분
    timetable.sort() # 오름차순 정렬

    busTime = [9*60+t*i for i in range(n)]  # 09:00부터 버스가 오는 시간

    i = 0  # 버스에 탈 크루의 인덱스
    for bt in busTime:  # 버스 도착시간을 순회하면서
        cnt = 0  # 버스에 타는 크루 수
        while cnt < m and i < len(timetable) and timetable[i] <= bt:
            # 버스에 타는 크루 수가 정원보다 작고
            # 버스에 탈 크루의 인덱스가 타임 테이블의 길이보다 작고
            # 타임테이블[i]가 버스 도착시간보다 크거나 같다면
            # 즉, 버스에 탈 조건을 모두 만족한다면
            i += 1 # 크루 인덱스 +1
            cnt += 1 # 탄 사람

        if cnt < m:  # 버스 정원보다 탄 사람이 작다면 타도 되므로
            answer = bt # 현재 도착시간을 answer에 대입
        else:  # 버스에 탈 자리 없으면 맨 마지막 크루보다 1분전에 도착
            answer = timetable[i-1]-1

    return str(answer//60).zfill(2)+":"+str(answer%60).zfill(2)
    # 다시 시간으로 변경해야하므로
    # answer//60, 2글자중 빈자리는 0으로 채우기(시간)
    # answer%60, 2글자중 빈자리는 0으로 채우기(분)