# 17687 - N진수 게임
# 10이상 숫자는 파이썬처럼 한 자리씩 끊어 말하기
# 2진법~16진법까지 모든 진법 가능

def trans_n_nary(n, number): # n진법으로 변환하는 함수(n진법, 변환하고자 하는 수)
    s = '0123456789ABCDEF' # 0부터 F까지 (~16진수)
    result = ''
    if number == 0: # 만약 0이라면 0 리턴
        return '0'
    while number: # number가 0이 될 때까지 반복
        result = s[number % n] + result
        # number를 n으로 나눈 나머지로 s값에 맞는 문자와 result를 붙이기
        number //= n # n으로 나누어 반복
    return result

def solution(n, t, m, p):
    answer = ''
    text = '' # n진법으로 변환한 수 저장할 변수
    for i in range(t*m): # t*m은 개수 * 인원이므로 총 진행되는 숫자 개수
        text += trans_n_nary(n, i) # n진법으로 t*m의 개수만큼 모두 구하기

    for i in range(p-1, t*m, m): # p-1(내 순서)부터 t*m-1(총 개수) 까지, m(인원)단위로 반복
        answer += text[i] # n진법으로 변환한 text를 내 순서가 올때마다 answer에 더하기

    return answer 