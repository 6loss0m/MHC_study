# 60058 - 괄호 변환
def split_to_uv(p):
    stack = []
    left = 0
    right = 0
    correct = True #올바른 괄호 문자열인지 검사

    for i, pp in enumerate(p):
        if pp == '(': # 왼쪽 괄호
            left += 1
            stack.append('(') # 스택에 추가
        else: # 오른쪽 괄호
            right += 1
            if len(stack) == 0: #스택이 비어있으면, 올바르지 않은 괄호
                correct = False
            else: # 스택이 비어있지 않다면 올바른 괄호
                stack.pop() # 스택에서 왼쪽 괄호 제거
        if left == right: # 왼쪽과 오른쪽의 괄호 개수가 같다면 (균형잡힌 괄호 문자열이라면)
            return i+1, correct #v의 시작 인덱스, u의 올바른 괄호 문자열 여부 전달


def solution(p):
    # 1 입력이 빈 문자열인 경우
    if len(p) == 0:
        return p
    # 2 균형잡힌 괄호 문자열 u, v로 분리
    v_idx, u_correct = split_to_uv(p)
    u = p[:v_idx]
    v = p[v_idx:]
    # 3 올바른 괄호 문자열이라면 1단계부터 수행
    if u_correct == True:
        # 3-1
        return u + solution(v)
    # 4 올바른 괄호 문자열이 아니라면
    else:
        # 4-1 (를 붙이기
        # 4-2 1단계 재귀 수행
        # 4-3 ) 붙이기
        answer = '(' + solution(v) + ')'
        # 4-4 u의 첫 번째와 마지막 문자 제거, 괄호 방향 뒤집기
        for i in range(1, len(u)-1):
            if u[i] == '(':
                answer += ')'
            else:
                answer += '('
        # 4-5 생성된 문자열 반환
        return answer