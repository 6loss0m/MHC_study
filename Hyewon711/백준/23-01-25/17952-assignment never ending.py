"""
    17952 - 과제가 긑나지 않아!
    1. 입력이 들어오면 가장 최근에 들어온대로 시작하므로 stack
    2. 새로운 과제가 나온다면 하던 과제를 중단하고 새운 과제 진행
    3. 과제가 끝났다면 이전에 하던 과제를 하던 부분부터 이어하기

    # 과제 학기 몇분인지
    # 1 점수 시간

"""
import sys
from collections import deque
input = sys.stdin.readline

n = int(input()) # 이번 학기가 몇 분인지 저장하는 변수
stack = deque()

result = 0

for _ in range (n) :
    assignment = list(map(int, input().split()))

    if assignment[0] == 1 : # stack이 비거나 assignment의 앞자리가 1인 경우
        stack.append([assignment[1],assignment[2]]) # stack에 과제 추가
    else : # 앞자리가 0인 경우 pass (다음 행동 수행)
        pass

    if stack : # 스택이 존재하는 경우
        stack[-1][-1] -= 1 # 가장 나중에 받은 과제를 진행 시간-1
        if stack[-1][-1] == 0 : # 진행 후에 과제를 다 끝낸 상태라면
            result += stack[-1][0] # 점수 추가
            stack.pop() # 완료한 과제 pop

print(result)