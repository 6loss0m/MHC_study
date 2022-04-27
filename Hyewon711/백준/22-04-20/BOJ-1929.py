# BOJ 1929 - 소수 구하기
import sys
m, n = map(int, sys.stdin.readline().split())

# for i in range(m, n+1, 1):
#     cnt = 0
#     for j in range (1, i+1):
#         if i % j == 0 :
#             cnt += 1
#     if (cnt==2) :
#         print(i)

def isprime(m, n): # 에라토스테네스의 체 이용
    n += 1
    prime = [True] * n # n개의 True가 있는 리스트 생성
    for i in range (2, int(n**0.5)+1): # 제곱근까지만 검사
        # 제곱근만으로 구해지는 이유 : A = a*b 라고 가정했을 경우, a와 b 모두 제곱근A보다 클 수 없다
        if prime[i] : # prime[i]가 True 라면 (소수라면)
            for j in range(2*i, n, i): # prime 내 i 배수들 False 변환 (2*i = i+i)
                prime[j] = False # i이후 i의 배수들을 False 판정

    for i in range(m, n):
        if prime[i] == True: # prime[i] == True 인 경우 == 소수인 경우
            if i == 1 : # i == 1인 경우 넘어가기
                continue
            print(i) # 소수인 경우 출력

isprime(m, n)