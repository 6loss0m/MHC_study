# 요구사항대로 push_front, push_back, pop_front, pop_back, size, empty, front, back이 입력되면 조건문을 실행할 수 있도록 구현한다.

from collections import deque
import sys 

n = int(input())
queue = deque() # 앞, 뒤 양쪽방향에서 elemnet 추가/삭제할 수 있는 양방향 큐

for _ in range(n):
    cmd = sys.stdin.readline().split()
    if cmd[0]=='push_front': #push_front X: 정수 X를 덱의 앞에 넣는다.
        queue.appendleft(int(cmd[1])) #cmd[0]은 명령어부분, cmd[1]은 push와 같은 명령어를 처리하기 위한 정수 부분
        
    elif cmd[0]=='push_back': #push_back X: 정수 X를 덱의 뒤에 넣는다.
        queue.append(int(cmd[1])) #cmd[0]은 명령어부분, cmd[1]은 push와 같은 명령어를 처리하기 위한 정수 부분
        
    elif cmd[0]=='pop_front': #pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if queue: 
            print(queue.popleft())
        else:
            print("-1")
            
    elif cmd[0]=='pop_back': #pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if queue: 
            print(queue.pop())
        else:
            print("-1")            
            
    elif cmd[0]=='size': #size: 스택에 들어있는 정수의 개수를 출력한다.
        print(len(queue))
        
    elif cmd[0]=='empty': #empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        if len(queue)==0:
            print(1)
        else:
            print(0)
            
    elif cmd[0]=='front': # front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if queue:
            print(queue[0])
        else:
            print("-1")

    elif cmd[0]=='back': # back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if queue:
            print(queue[-1])
        else:
            print("-1")