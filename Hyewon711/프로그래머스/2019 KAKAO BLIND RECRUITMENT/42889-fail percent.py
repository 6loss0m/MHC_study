# 42889 - 실패율
# 리턴값 : 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
# count 매소드, 딕셔너리를 이용하여 풀면 좋을 듯

def solution(N, stages):
    m = len(stages) # 플레이어 수
    fail = {} # 실패율

    for i in range(1, N+1):
        stage = stages.count(i) # 각 단계별 도전하는 플레이어 수 count
        # print(stage) # 1부터 각 단계별 도전 플레이어 수가 출력된다.
        fail_cnt = 0 # 실패한 횟수

        if stage != 0: # stage 비어있지 않다면
            print(stage)
            fail_cnt = stage / m # 실패율 계산 ( 도전하는 플레이어 수 / 스테이지 도달한 플레이어 수 )
        fail[i] = fail_cnt # 스테이지별 실패율 저장
        m -= stage
    answer = sorted(fail, key =lambda x: fail[x], reverse =True)
    # 실패율이 같다면 작은 번호의 스테이지가 먼저 오도록 한다.

    return answer