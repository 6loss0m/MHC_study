# 77886 - 110 옮기기
# https://prgms.tistory.com/57
# 1) s에서 뽑을 수 있는 "110"을 그리디하게 뽑을 수 있을 때까지 계속 뽑아낸다. 스택을 사용하면 선형 시간 복잡도 내에 모든 "110"들을 뽑아낼 수 있다.
# 2) 추출한 "110"들을 1번과정에 의해 변형된 s에서 나타나는 최초의 "111" 바로 앞에 삽입한다. ("111"이 s에서 나타나지 않으면 맨 뒤에 삽입)


def solution(s):
    answer = []
    for string in s: # 문자열 배열 s, 각 요소로 반복문 돌리기
        stack = []
        counting = 0
        count_1 = 0

        for st in string: # 요소의 문자열 1개씩 비교...
            if(len(stack) >= 2 and stack[-1] == '1' and stack[-2] =='1' and st =='0'):
                # 현재 stack의 길이가 2 이상이고, 스택이 '11'로 끝나고 st가 0이라면
                # 110 넣을 예정!
                counting += 1 # 문자열 옮긴횟수 +1
                stack.pop() # '11' pop
                stack.pop()
            else: # if문 충족하지 않는다면 stack에 문자 추가
                stack.append(st)

        for st in stack[::-1]: # 스택을 확인, 역순으로 확인하기
            if st == '0': # 0을 만나면 break
                break
            else: # 1만 있는 경우 1의 개수 count
                count_1 += 1
        # print(stack[:len(stack)-count_1])

        # 110이 들어가는 자리는?
        # 가장 뒤에 나오는 0 뒤
        # 0이 없다면 가장 앞에 있는 1 앞

        # stack에 남은 문자열은 110 앞에 붙을 문자열 + 110 + 110 뒤에 붙을 1의 개수
        answer.append(''.join(stack[:len(stack)-count_1])+(counting)*'110'+count_1*'1')

    return answer