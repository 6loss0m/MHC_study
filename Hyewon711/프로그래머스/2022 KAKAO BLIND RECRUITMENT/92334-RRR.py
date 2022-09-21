# 92334 - 신고 결과 받기
# 같은 사람이 여러 번 신고해도 신고 횟수는 1회
# report는 신고한 사람 id, 신고 당한 사람 id로 나누어지므로 split(' ')로 먼저 분리하자.

def solution(id_list, report, k): # 이용자 ID, 신고한 이용자 ID정보, 신고 횟수
    answer = [0] * len(id_list)
    report = set(report) # 각 이용자가 신고한 이용자의 ID정보
    # set이므로 중복은 받지않기에 동일 신고는 생각해도 되지 않음
    check_list = {}
    check = {}

    for i in report :
        send, recive = i.split(' ')

        if recive not in check :
            check[recive] = 1 # 신고 당한 적 없으면 해당 check[recive]는 1로 저장
        else :
            check[recive] += 1 # 이미 전적이 있다면 +1

        if send not in check_list : # 신고한 사람이 check_list에 없다면
            check_list[send] = [recive] # check_list[send]에 신고한 아이디를 저장
        else : # 만약 신고한 사람이 check_list에 있다면 (한명이 여러명을 신고한 경우)
            if recive not in check_list[send] : # check_list[send]에 신고한 아이디가 없다면
                check_list[send] += [recive] # 새로운 신고이므로 신고자 목록에 추가

    for id_, n in check.items():
        if n >= k:
            for user, user2 in check_list.items():
                if id_ in user2:
                    answer[id_list.index(user)] += 1
    return answer