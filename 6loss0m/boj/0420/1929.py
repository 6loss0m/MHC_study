# 소수 구하기
def prime(num):
    if num==1:
        return False
    else:
        # 약수는 대칭으로 이루어져 있기 때문에
        # 해당 수의 제곱근까지만 나눠보기
        for i in range(2, int(num**0.5)+1):
            if num%i == 0:
                return False
        return True

M, N = map(int, input().split())

for i in range(M, N+1):
    if prime(i):
        print(i)