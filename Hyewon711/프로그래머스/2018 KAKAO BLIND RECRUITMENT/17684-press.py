# 17684 - 압축
# LZW 알고리즘: 텍스트를 훑어가며 n-gram을 찾아가면서 인코딩을 구성

def solution(msg):
    answer = []
    eng = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'] # eng[0]부터 eng[25] 까지

    while len(msg) > 0: # msg가 모두 돌 때까지 반복
        w = msg[0] # 첫번째 문자를 w에 넣기, w는 가장 긴 문자열을 찾을 때 쓸 변수
        cnt = 0

        if len(msg) == 1: # 만약 msg 길이가 1이라면 (알파벳이 하나 남은 경우)
            answer.append(eng.index(w)+1) # 사전을 참고하여 index(w)+1의 값으로 answer에 바로 추가
            # 색인번호가 1부터 시작되므로 +1 인덱스로 찾아야 함
            break # 종료

        while len(w) < len(msg): # msg가 가장 긴 문자열 w보다 긴 경우 반복
            s = w # 현재 입력에 w를 대입
            cnt += 1 # cnt 추가
            w += msg[cnt] # 현재 입력에 msg[cnt]의 값을 w에 붙이기
            # 그 뒤에 문자열까지 합친 값이 eng에 있을 경우 빨리 찾을 수 있으므로 뒤에 문자열을 붙인다.

            if w not in eng: # 만약 현재입력+뒤 문자를 붙인 w가 eng에 들어있지 않은 경우
                w = s # 현재 입력값을 이전의 입력값으로 수정
                # ex) KAKAO 에서 s가 KA일 때 K를 붙여 w를 KAK로 변경, 사전에 있는지 확인하는 절차이다.
                # KAK가 사전에 없다면 w를 다시 s로 돌리고 break
                break

        answer.append(eng.index(w)+1) # 사전에서 찾은 현재입력 w의 인덱스를 answer에 append
        print(eng.index(w))
        msg = msg[len(w):] # msg는 이미 추가한 w의 문자열 길이 이후부터 다시 반복
        if msg: # msg에 문자열이 남아있다면
            eng.append(w + msg[0]) # 현재 입력값에 msg[0], 즉 다음 문자를 붙여서 사전에 새로 추가한다.
    return answer
