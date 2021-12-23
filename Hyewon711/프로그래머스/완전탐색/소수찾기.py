#소수 = 자기 자신과 1로만 나누어떨어지는 자연수

#itertools.permutations :  소수 판별 함수

#예시 
#lst = list(permutations('day'))
#print(lst)
#[('d', 'a', 'y'), ('d', 'y', 'a'), ('a', 'd', 'y'), ('a', 'y', 'd'), ('y', 'd', 'a'), ('y', 'a', 'd')]

from itertools import permutations

def solution(numbers):
    answer = 0
    prime = []
    
    # 종이 조각으로 만들 수 있는 모든 숫자 조합
    for i in range(1,len(numbers)+1):
        prime += set(map(''.join, permutations(numbers,i))) #문자열 합치기 
    prime = set(map(int, prime)) # 문자열을 int형으로 
    prime -= {0, 1} # 2보다 작은 1,0의 경우 소수 X
    
    composite = set() # 합성한 수를 저장 (uniqe 값만)
    for num in prime:
        #에라토스테네스의 체
        #2부터 number/2 + 1까지의 수중에서 하나 이상으로 나눠떨어지는지 확인
        #나누어 떨어지면 소수X, 나누어 떨어지지 않으면 소수이다.
        for i in range(2, num//2+1): # n의 제곱근 보다 작은 숫자까지만 나눗셈
            if num % i == 0: # 나누어 떨어지는 수가 있으면 소수가 아님
                composite.add(num)
    prime -= composite # 숫자 조합에서 소수가 아닌 수 제거
    answer = len(prime) #저장된 소수 개수가 answer
        
    return answer