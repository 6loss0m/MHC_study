from itertools import permutations 
import math

# 소수 판단 알고리즘
# 제곱근까지만 보고 소수를 판별하는 함수
def isPrime(a):
    if a < 2:
        return 0
    for i in range(2,a):
        if a % i == 0 :
            return 0
    return 1

def solution(numbers):
    answer = 0
    num_list = []
    perlist = []
    # 문자열 나누기
    for i in range(len(numbers)):
        num_list.append(numbers[i:i+1])
        
    # numbers의 각 숫자들을 순열로 모든 경우 만들기
    for i in range(1, len(numbers)+1):            
        perlist += list(permutations(num_list, i))
    new_nums = [int(('').join(n)) for n in perlist]
    num_list = list(set(new_nums))

    for i in num_list:
        answer = answer + isPrime(i)
    
    return answer