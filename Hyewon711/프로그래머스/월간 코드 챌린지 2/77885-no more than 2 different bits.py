#77885 - 2개 이하로 다른 비트
def solution(numbers):
    answer = []

    for number in numbers:
        if number%2 == 0: # number가 짝수이면 1을 더하기
            answer.append(number + 1)
            continue
        # number가 홀수라면 아래 코드 실행
        n = bin(number)[2:][::-1] + '0'
        # 2진수 역순으로 표현 (bin은 10진수->2진수 문자열로 바꾸는 함수) + 0 붙이기
        # 역순으로 하면 맨앞에 0을 붙이는 것과 동일
        # [2:] -> 2진수를 나타내는 접두어 0b가 붙어있으므로 [2:]를 해주어야 한다.

        zero = n.find('0') # 역순 문자열 왼쪽(실제론 오른쪽)부터 찾아서 처음 나오는 0의 인덱스
        n = (n[:zero-1]+'01' + n[zero+1:])[::-1] # 1 0 -> 0 1 바꾼 후 다시 역순으로 돌리기
        # zero는 가장 처음 나온 0의 인덱스
        answer.append(int(n, 2)) # 10진수로 변경 후 list에 추가

    return answer