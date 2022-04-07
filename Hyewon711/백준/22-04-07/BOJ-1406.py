# BOJ - 1406 에디터
# 커서 위치를 저장하는 변수를 설정하면 시간초과가 난다. 

from sys import stdin
from collections import deque

l = list(stdin.readline().strip()) # readline으로 입력받되 개행문자 포함 X, 편집기에 입력되어 있는 문자열이다.
left = deque(l) # 커서의 왼쪽
right = deque() # 커서의 오른쪽

for _ in range(int(input())):
	commands = stdin.readline().split() # 명령어 입력 
	com = commands[0]
	if com == 'L': # 커서를 왼쪽으로 한 칸 옮김
		if left:
			right.appendleft(left.pop())
	elif com == 'D': # 커서를 오른쪽으로 한 칸 옮김
		if right:
			left.append(right.popleft())
	elif com == 'B': # 커서 왼쪽에 있는 문자를 삭제함 
        # 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
		if left: 
			left.pop() 
	elif com == 'P': # $라는 문자를 커서 왼쪽에 추가함
		left.append(commands[1]) # commands[0]은 명령어, commands[1]은 P 명령어 실행시 추가할 문자
        
print(''.join(left + right))