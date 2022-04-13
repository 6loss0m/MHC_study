# BOJ - 1850 최대공약수 
# 나누었을 때 나머지 0인 값중 가장 큰 값을 최대 공약수 (max) 
# 파이썬에선 math 모듈에 최대공약수 함수 gcd, 최소공배수 함수 lcm이 존재한다.

# 모든 자리가 1로만 이루어져있는 두 자연수 a, b가 주어진다. 
"""
import sys 

a, b = map(int, sys.stdin.readline().split())
tmp = []

for i in range(1, min(a,b) + 1): # 1부터 두 수중 더 작은 수까지 반복
    if a % i == 0 and b % i == 0: # 나머지가 0인 경우 
        tmp.append(i) # tmp에 추가한다.

print("1" *max(tmp)) # 최대공약수는 tmp에서 가장 큰 값이 된다.
"""

from fractions import gcd

a,b = map(int, input().split())

for i in range(int(gcd(a,b))):

    print(1, end="")
