# BOJ - 1934 최소공배수
# 공배수 중 가장 작은 공배수 (min)
# 파이썬에선 math 모듈에 최대공약수 함수 gcd, 최소공배수 함수 lcm이 존재한다.

t = int(input())

tmp = []
for i in range(t): 
    a, b = map(int, input().split()) # 최소공배수를 구할 a, b 입력

    for j in range(1, min(a,b)+1): # 1부터 두 수중 더 작은 수까지 반복
        if a % j == 0 and b % j == 0: # 나머지가 0인 경우 
            tmp.append(j) # tmp에 추가한다.

    print((a * b) // max(tmp)) # 최소 공배수는 두 수의 곱을 최대공약수로 나눈 몫이 된다.
    tmp = [] # tmp 초기화