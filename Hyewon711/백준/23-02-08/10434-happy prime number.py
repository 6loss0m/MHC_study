"""
    10434 - 행복한 소수
"""
import sys
input = sys.stdin.readline

def check(n): # 각 자리 제곱 수 합 구하기
    sum = 0
    for _ in range (50):
        n = str(n) # a를 문자열로 치환하여 한자리씩 바교
        for i in n: # 앞자리부터 확인
            sum += int(i)**2 # 각 자리 제곱하여 더하기
        n = sum
        sum = 0
    if n == 1 :
        return True
    else :
        return False

def prime(m): # 행복한 소수 판별
    for i in range(2, int(m**0.5)+1): # 에라토스테네스의 체로 소수 판별
        if m % i == 0: # 나누어 떨어진다면 소수가 아님!
            return False
    return True

n = int(input())

for i in range (n):
    a, b = map(int, input().split())

    if b == 1 : # 1은 소수가 아님!
        print(str(a) + " " + str(b) + " " + "NO")
    elif check(b) and prime(b) : # 제곱 수의 합과 행복한 소수 모두 만족되어야 YES
        print(str(a) + " " + str(b) + " " + "YES")
    else :
        print(str(a) + " " + str(b) + " " + "NO")
