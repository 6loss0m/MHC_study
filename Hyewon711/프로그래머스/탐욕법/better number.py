def solution(number, k):
    answer = ''
    for i in number:
        #맨 뒤에 값과 비교, i가 더 클 경우
        while len(answer) > 0 and int(answer[-1]) < int(i) and k > 0:
            k -= 1 # 값 제거
            answer = answer[:-1] # 맨 뒤의 값 1개 제거
            
        answer += i #
        
    if k > 0:
        answer = answer[:-k]# 남아있는 K 값 만큼 뒤에 값 빼기. 
    return answer