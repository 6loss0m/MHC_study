# BOJ 6588 -　골드바흐의 추측
# 골드바흐는 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다고 한다.
# 예 ) 8 = 3 + 5 / 20 = 3 + 17 = 7 + 13 / 42 = 5 +37 = 11 + 31 = 13 + 29 = 19 + 23
# 조건 ) 끝날때는 0을 입력받기, n = a + b 형태일때, 답이 여러개라면 b - a 의 결과가 가장 큰 것을 출력한다.
# 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
import sys
num = 1000001
li = [True for _ in range(num)] # 100만 만큼 True 리스트 생성

# 에라토스테네스의 체로 소수 판별하기
for i in range(2, int((num-1)**0.5)+1): # 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
    # 제곱근만으로 구해지는 이유 : A = a*b 라고 가정했을 경우, a와 b 모두 제곱근A보다 클 수 없다
    if li[i] : # li[i]가 True 라면 (소수라면)
        for j in range(i+i, num, i): # i이후 i의 배수들을 False 판정
            li[j] = False

while True:
    n = int(sys.stdin.readline())
    if n==0 : # 0이 입력되는 경우 break
        break

    cnt = 0
    for i in range (3, len(li)):
        if li[i] :
            if li[n-i] :
                print(n,'=',i,'+',n-i)
                cnt = 1
                break

    if cnt == 0 :
        print("Goldbach's conjecture is wrong.")


# 시간초과 코드
#
# num = 1000001
# li = [True for _ in range(num)] # 100만 만큼 True 리스트 생성
#
# def isprime(n) : # 에라토스테네스의 체로 소수 판별하기
#     for i in range(2, int(n**0.5)+1): # 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
#         if li[i] : # li[i]가 True 라면
#             for j in range(i+i, num, i): # 지워지지 않은 경우 자기자신을 제외한 수부터 배수 지우기
#                 li[j] = False
#
# while (True):
#     n = int(input())
#     if n==0 : # 0이 입력되는 경우 break
#         break
#
#     cnt = 0
#     for i in range (3, len(li)): # 입력값이 짝수이므로 2단위로 증가
#         if isprime(i) :
#             if isprime(n-i) :
#                 print(n,'=',i,'+',n-i)
#                 cnt = 1
#                 break
#
#     if cnt == 0 :
#         print("Goldbach's conjecture is wrong.")
