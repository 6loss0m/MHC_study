# BOJ 9613 - GCD 합
# 가능한 모든 쌍의 GCD의 합
def gcd(a, b):
    # 유클리드 호제법
    # a를 b로 나눈 나머지를 n 이라고 하면 (a % b = n) n이 0일때, b가 최대 공약수(GCD)
    if b == 0:
        return a
    aa = a % b
    return gcd(b,aa)

n = int(input()) # 입력받을 테스트 케이스 개수

for _ in range(n): # 입력받은 테스트 케이스 개수만큼 반복
    case = list(map(int,input().split())) # 테스트 케이스 입력
    ans = 0 # 최대공약수의 합을 저장할 ans 초기화

    for i in range(1, len(case)-1): # 1부터 입력한 테스트케이스 개수 -1 만큼 반복, 마지막 테스트케이스와 마지막 직전 테스트케이스를 비교해야하므로 len(case)-1
        for j in range(i+1, len(case)): # i+1 부터 입력한 테스트케이스 개수만큼 반복
            ans += (gcd(case[j], case[i]))
            # case에 저장된 테스트케이스 값들을 gcd 함수를 통해 구해진 최대공약수를 ans에 합
    print(ans) # 더해진 ans 값이 최대공약수들의 합