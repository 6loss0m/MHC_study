# BOJ - 2609 최대공약수와 최소공배수
# 나누었을 때 나머지 0인 값중 가장 큰 값을 최대 공약수 (max) 
# 공배수 중 가장 작은 공배수 (min)
# 파이썬에선 math 모듈에 최대공약수 함수 gcd, 최소공배수 함수 lcm이 존재한다.

a, b = map(int, input().split())

tmp = []
for i in range(1, min(a,b) + 1): # 1부터 두 수중 더 작은 수까지 반복
    if a % i == 0 and b % i == 0: # 나머지가 0인 경우 
        tmp.append(i) # tmp에 추가한다.

print(max(tmp)) # 최대공약수는 tmp에서 가장 큰 값이 된다.
print((a * b) // max(tmp)) # 최소 공배수는 두 수의 곱을 최대공약수로 나눈 몫이 된다. 