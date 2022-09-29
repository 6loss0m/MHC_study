# 72414 - 광고 삽입
# 공익 광고를 삽입하는데, 시청한 시청자들의 누적 재생시간이 가장 큰 구간에 하려 한다.
# 공익 광고가 들어갈 시작 시각을 구하기, 누적 재생시간이 가장 많은 곳이 여러곳이라면 그중 가장 빠른 시작 시각 return
# https://dev-note-97.tistory.com/156

def solution(play_time, adv_time, logs):
    # str_to_int : 초로 변환하는 함수
    # int_to_str : 변환된 초를 문자열 (hh:mm:ss) 형식으로 바꾸는 함수

    play_time = str_to_int(play_time) # 동영상 길이 (초)
    adv_time = str_to_int(adv_time) # 광고 길이 (초)
    all_time = [0 for i in range(play_time + 1)] # 모든 시간동안 시청자 수를 저장할 리스트

    for l in logs: # 시간을 초로 변환
        start, end = l.split('-') # -를 기준으로 나누기
        start = str_to_int(start) # 시작 (초)
        end = str_to_int(end) # 끝 (초)
        all_time[start] += 1 # 현재 시청중인 시청자 수 +1
        all_time[end] -= 1 # 현재 시청중인 시청자 수 -1

    for i in range(1, len(all_time)): # 구간 별 시청자 수 기록
        all_time[i] = all_time[i] + all_time[i - 1] # 1초 동안의 시청자수

    for i in range(1, len(all_time)): # 모든 구간 시청자 누적 기록
        all_time[i] = all_time[i] + all_time[i - 1]

    most_view = 0
    max_time = 0
    for i in range(adv_time - 1, play_time): # 처음부터 끝까지 반복문을 탐색
        if i >= adv_time: # 만약 i값이 광고 길이와 같거나 크다면?
            if most_view < all_time[i] - all_time[i - adv_time]: # 누적 시청자수 (most_view)와 현재 구간의 누적 시청자수를 비교
                most_view = all_time[i] - all_time[i - adv_time]  # 현재 누적 시청자수가 더 많다면 most_view를 갱신
                max_time = i - adv_time + 1 # 광고 삽입 시간을 변경
        else:
            if most_view < all_time[i]: # 가장 많은 누적 시청자수와 누적 시청자수 비교
                most_view = all_time[i] # most_view보다 all_time[i]가 더 큰 경우 갱신
                max_time = i - adv_time + 1 # 광고 삽입 시간 변경
    print(max_time)
    return int_to_str(max_time)


def str_to_int(time): # 초로 변환
    h, m, s = time.split(':')
    return int(h) * 3600 + int(m) * 60 + int(s)


def int_to_str(time): # 문자열로 변환 (다시 문제와 동일 형태로 바꾸기)
    h = time // 3600
    h = '0' + str(h) if h < 10 else str(h)
    time = time % 3600
    m = time // 60
    m = '0' + str(m) if m < 10 else str(m)
    time = time % 60
    s = '0' + str(time) if time < 10 else str(time)
    return h + ':' + m + ':' + s