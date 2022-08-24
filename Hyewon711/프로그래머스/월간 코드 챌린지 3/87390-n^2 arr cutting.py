# 87390 - n^2 배열 자르기
# 그대로 잘라서 붙였더니.. O(n^2) 테스트케이스 6개만 통과하고 시간초과
# 10^7 * 10^7 까지 가니까 당연히 시간초과가 날 수밖에 없었다.

def solution(n, left, right):
    answer = []

    for i in range(left, right+1): #  left~right를 반복문의 범위로 설정
        answer.append(max(i//n, i%n) + 1)
        # i를 n으로 나눈 몫과 i를 n으로 나눈 나머지 중 더 큰 값에 +1

    return answer