# 72410 - 신규 아이디 추천
# 주어진 7단계 조건을 하나씩 구현하면 된다.

def solution(new_id):
    # 1단계 - 대문자를 소문자로 치환
    new_id = new_id.lower()
    # 2단계 - 소문자, 숫자, -, _, . 을 제외한 모든 문제 제거
    answer = ''
    for i in new_id :
        if i.isalnum() or i in '-_.' : # isalnum : 영문자 또는 숫자인 경우만 참을 리턴
            answer += i
    # 3단계 - .이 2번 이상 연속된 부분은 .으로 치환
    while '..' in answer :
        answer = answer.replace('..', '.')
    # 4단계 - 처음이나 끝에 . 이 있다면 제거
    if answer[0] == '.' and len(answer) > 1 : # 처음에 . 이 있음
        answer = answer[1:]
    if answer[-1] == '.' : # 끝에 . 이 있음
        answer = answer[:-1]
    # 5단계 - 빈 문자열이라면 new_id에 a 대입
    if answer == '' :
        answer = 'a'
    # 6단계 - 길이가 16자 이상이라면 첫 15개 문자를 제외한 나머지 문자는 제거
    # 제거 후 마침표가 끝에 있다면 끝에 위치한 마침표 제거
    if len(answer) >= 16 :
        answer = answer[:15]
        if answer[-1] == '.' :
            answer = answer[:-1]
    # 7단계 - 길이가 2자 이하라면, 마지막 문자를 3이 될 때까지 반복
    if len(answer) <= 2 :
        for k in range(3 - len(answer)) :
            answer += answer[-1]

    return answer