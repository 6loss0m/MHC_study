# 17682 - 다트게임

def solution(dartResult):
    answer = 0
    stack = []
    dic = {"S": 1, "D": 2, "T": 3} # single, double, triple
    dartResult = dartResult.replace("10", "A")
    # 10은 1과 0이므로 A로 변환

    for i in dartResult :
        if i.isdigit() or i == "A":
            stack.append(10 if i == "A" else int(i))
            # 만약 i == "A" 라면 10을, 아니라면 int(i)를 append
        elif i in ["S", "D", "T"]:
            # 영역이 존재하는 경우
            num = stack.pop()
            stack.append(num ** dic[i])
        elif i == "#": # 아차상
            stack[-1] *= -1 # 해당 점수 마이너스
        elif i == "*": # 스타상 (바로 전 점수, 이전 점수 2배)
            num = stack.pop() # 1번
            if len(stack): # 꺼냈음에도 요소가 남아있는 경우
                stack[-1] *= 2 # 2번) 스택에 쌓인 마지막 영역 2배
            stack.append(2 * num) # 1번에서 pop한 값의 2배 append

    answer = sum(stack) # 스택에 쌓은 모든 값 sum
    return answer