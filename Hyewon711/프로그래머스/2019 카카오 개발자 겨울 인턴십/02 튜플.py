def solution(s): # 시간 제한 없음
    # 빈번히 나온 숫자 길이 순이 result 값이 된다.
    answer = [] 
    s = s[2:-2] #s의 길이는 5이상, 100만 이하, "{{"과 "}}"를 제외
    
    s = s.split("},{") # 1. '},{' 를 만날 때마다 분리(split)한다.
    s.sort(key = len) # sort(key = len) : 리스트 요소를 길이 순으로 정렬 
    
    for i in s:
        li = i.split(',') # 2. ',' 를 만날 때마다 분리(split)한다.
        # "{{1,2,3},{2,1},{1,2,4,3},{2}}"인 경우, 
        # [['2'], ['2','1'], ['1','2','3'], ['1','2','4','3']]이 된다.
        for j in li:
            if int(j) not in answer:
                answer.append(int(j))
                #answer에 요소가 없는 경우(not in), answer에 해당 값을 int으로 변경하여 추가하고 추가한 후 
                #내부의 for문을 break하는 방식으로 계속적으로 추가해야만 원래 원소들의 순서를 찾아낼 수 있다.
    return answer

# split으로 직접 분리하여 리스트 요소를 추출하는 것이 아닌
# 파이썬의 내장 모듈 numbers 사용하여 숫자만 추출하는 방법도 있다.
# import re 
# numbers = re.findall("\d+", j)
# findall : 정규식과 매치되는 모든 문자열을 리스트 형식으로 리턴