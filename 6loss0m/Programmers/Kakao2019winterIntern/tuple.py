def solution(s):
    answer = [] 
    s = list(eval(s[1:-1]))
    #문자열을 리스트로 변경
    if len(s) == 1:
        answer.append(s[0])
    else: 
        temp = sorted(s, key=lambda x: len(x))
        print(temp)
        # 원소 개수별로 정렬 
        temp = [list(i) for i in temp]
        print(temp)
        # 내부 집합 자료형을 리스트로 변경
        for item in temp: 
            for j in range(len(item)): 
                if item[j] not in answer:
                    answer.append(item[j]) 
                else:
                    continue 
    return answer