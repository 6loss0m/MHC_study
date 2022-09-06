# 42888 - 오픈채팅방
# 중복 닉네임 허용,
# Enter : 입장, Leave : 퇴장, Change : 닉네임 변경

def solution(record):
    answer = []
    uid = {}
    result = []

    for i in record:
        t = i.split()  # 0 : 명령어, 1 : id token, 2 : 닉네임
        if t[0] == 'Enter':
            uid[t[1]] = t[2]  # uid[id] 값을 닉네임으로 저장
            result.append([t[1], '님이 들어왔습니다.'])  # 결과값 저장
        elif t[0] == 'Leave':
            result.append([t[1], '님이 나갔습니다.'])  # 결과값 저장
        else:
            uid[t[1]] = t[2]  # uid[id] 값을 닉네임으로 저장

    for i in result:
        i[0] = uid.get(i[0])  # uid 가장 첫번째 요소(t[1]) 가져오기
        answer.append(''.join(j for j in i))  # answer에 t[1]과 뒷 문자열 이어붙이기

    return answer