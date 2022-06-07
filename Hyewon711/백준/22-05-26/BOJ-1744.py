# BOJ 1744 - 수 묶기
# 위치 상관없이 묶을 수 있고, 자기자신은 불가능
# 묶었을 땐 묶은 수끼리 곱한다.
import sys

# 입력부
n = int(sys.stdin.readline())

# neg : 음수 리스트
# pos : 1 제외 양수 리스트
# zero : 0 리스트
# one : 1 리스트
neg = []
pos = []
zero = []
one = []

# 각 숫자를 경우에 따라 다른 리스트에 담는다
for i in range(n):
    n = int(sys.stdin.readline())
    if n < 0: # 음수일 때
        neg.append(n)
    elif n > 1: #양수일 때
        pos.append(n)
    elif n == 1: # 1일때
        one.append(n)
    else:
        zero.append(n)

# 음수는 내림차순 (절댓값이 큰 수가 앞에), 양수는 오름차순으로 정렬한다
neg.sort(reverse=True)
pos.sort()

# ans : 정답 배열
ans = []

# 음수 리스트에서 쌍을 추출후, 정답배열에 곱한 값을 넣는다
while len(neg) >= 2:
    ans.append(neg.pop() * neg.pop()) # 음수끼리 곱한 양수 결과를 ans 에 추가

# 남은 음수에 대해
while neg:
    # 0 리스트가 비지 않았다면 0과 나머지 음수를 묶어준다
    if zero:
        zero.pop()
        neg.pop()
    # 0 리스트가 비었다면 나머지 음수를 정답 배열에 추가한다
    else:
        ans.append(neg.pop())

# 양수 배열도 마찬가지로 한 쌍으로 묶은 값을 정답배열에 저장하고 남은 양수도 정답 배열에
# 그대로 저장한다
while len(pos) >= 2:
    ans.append(pos.pop() * pos.pop())
while pos:
    ans.append(pos.pop())

# 마지막으로 1을 정답 배열에 추가한다
while one:
    ans.append(one.pop())

# 정답 출력
print(sum(ans))