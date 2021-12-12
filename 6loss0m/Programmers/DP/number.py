# 일단 뭔 얘긴지 잘 모르겠음....
def solution(N, number):
    # N과 number가 같은경우
    # 예) N = 2, number = 2
    # 2 = 2, 2 = 2/2 + 2/2 -> 가장 작은 경우는 자기자신
    if N == number:
        return 1
    answer = -1
    # 8개의 set 리스트 생성
    # 8개인 이유는 최소값이 8이상인 경우 -1을 출력하기 위해
    S = [set() for _ in range(8)]
    # N, NN, NNN, NNN, ... 의 정수 생성
    for i in range(8):
        S[i].add(int(str(N)*(i+1)))
    print(S)
    # i : 1 ~ 8 
    for i in range(1, len(S)):
        # j : 0 ~ i 
        for j in range(i):
            # op1 : S[1~8]
            # 계산 가능한 경우 모두 추가
            # set은 중복을 제거
            for op1 in S[j]:
                for op2 in S[i-j-1]:
                    S[i].add(op1+op2)
                    S[i].add(op1-op2)
                    S[i].add(op1*op2)
                    if op2!=0:
                        S[i].add(op1//op2)
            print(S[1],S[2])
        # 만약 주어진 정수와 일치하면 정답 출력
        if number in S[i]:
            answer=i+1
            break

    return answer