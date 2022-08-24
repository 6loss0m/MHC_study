# 76502 - 괄호 회전하기
# 괄호는 왼쪽으로 s의 길이만큼 회전했을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수구하기

def solution(s):
        answer = 0
        for k in range(len(s)):
                temp = s[k:]+s[:k] # 문자열을 특정 인덱스를 기준으로 잘라 두 덩어리의 순서를 바꿔주기
                # temp는 왼쪽으로 한칸씩 이동하는 괄호 문자열
                print(temp)
                if check(temp): # check 함수 실행
                        answer += 1 # check가 true라면 answer += 1
        return answer


def check(temp): # 올바른 괄호 문자열 확인 함수
        arr = list(temp)
        if arr[0] in (')', '}', ']'): # 1) 오른쪽 소,중,대괄호가 첫 번째에 있다면 올바르지 않음
                return False
        if arr[-1] in ('(', '{', '['): # 2) 오른쪽 소,중,대괄호가 마지막에 있다면 올바르지 않음
                return False

        dict = {')': '(', '}': '{', ']': '['} # 괄호의 짝을 딕셔너리
        stack = []
        for x in arr: # 3) 문자열 비교
                if not stack: # 3-1) stack이 비어있는 경우 추가
                        stack.append(x)
                        # 3-2) x가 닫히는 괄호(keys)이고 and stack의 마지막이 dict[x]와 같다면 stack.pop()
                elif x in dict.keys() and stack[-1] == dict[x]:
                        stack.pop() # 스택의 마지막 요소 pop
                else: # 3-3) 스택에 추가
                        stack.append(x)
        if stack: # 스택이 비어있지 않다면 return False
                return False
        return True