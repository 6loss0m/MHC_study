# 12977 - 소수 만들기
# 소수는 에라토스테네스의 체로 판별, 조합은 combination을 이용
# nums에 들어있는 숫자의 개수는 3개 이상 50개 이하

from itertools import combinations

def is_prime(n): # 에라토스테네스의 체로 소수 판별
    m = sum(n) # 조합으로 들어온 수들의 합을 저장

    for i in range(2, int(m**0.5)+1): # n의 제곱근까지만 루프를 돌면서 배수들을 소수목록에서 지운다.
        if m % i == 0: # 나누어 떨어지는 경우
            return False

    return True

def solution(nums):
    answer = 0
    for n in combinations(nums, 3): # nums에서 3개의 조합
        if is_prime(n): # 만약 소수라면
            answer += 1 # ans +1

    return answer # 소수를 만들 수 있는 경우의 개수 출력