# BOJ 11729 - 하노이 탑 이동 순서
# https://www.youtube.com/watch?v=aPYE0anPZqI
# 원반의 총 개수가 홀수, 짝수냐에 따라 목적지 장대로 놓을 것 인지, 목적지가 아닌 장대로 놓을 것인지 결정된다.
import sys
input = sys.stdin.readline

n = int(input()) # 첫 번째 장대에 쌓인 원판의 개수

def hanoi(n, a, b, c):
    if n == 1:# n이 1인경우 가장 아래의 원판을 목적지(3) 장대로 옮기는 것이므로 바로 출력
        print(a, c) # A 장대 가장 위에 있는 원판을 B 장대 가장 위로 옮긴다
    else:
        hanoi(n-1, a, c, b) # 맨 아래칸 제외, 1 -> 2
        print(a, c)
        hanoi(n-1, b, a, c) # 맨 아래칸 제외, 2 -> 3
sum = 1
for i in range(n-1): #  하노이 탑 공식 개수 : P(n) = 2 P(n-1) + 1
    # 1 + 2+ 2*2 + 2*2*2 + ... = 2^n -1
    sum = sum * 2 + 1
print(sum) # 옮긴 횟수 k
hanoi(n, 1, 2, 3) # 원판의 개수, 3개의 장대