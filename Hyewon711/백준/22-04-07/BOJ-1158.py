n, k = map(int,input().split()) 
nl = [i for i in range(1,n+1)] # 리스트 길이를 지정한다.
answer = [] 
num = 0 

while len(answer) != n: # answer의 길이가 n (총 인원) 이 되면 while문을 빠져나온다.
    num = (num + (k-1)) % len(nl) # 원을 도는 주기인 num
    # 세 명중 다섯 번째 사람을 구하는 방법을 보았을 때, 5를 3으로 나눈 후 나머지 값과 동일하게 볼 수 있다.
    # 따라서 
    answer.append(nl.pop(num)) # 제거된 사람을 삭제한 리스트를 answer에 추가한다. 

print("<%s>" % (", ".join(map(str,answer))))

"""
import sys

n, k = map(int, sys.stdin.readline().split())

queue = [i for i in range(1, n + 1)]
temp = []
index = 0 # 제거할 인덱스

while queue:
    # 제거할 인덱스를 더해서 제거할 인덱스 위치를 바꾼다.
    index += k - 1

    # 인덱스의 크기가 남은 큐에 길이보다 크다면
    if index >= len(queue):
        # 인덱스의 크기를 나눠 나머지로 바꾼다.
        # 한바퀴 돌았기 때문
        index %= len(queue)

    # 큐에서 해당 인덱스를 제거하고 제거한 요소를 리스트에 추가한다.
    temp.append(str(queue.pop(index)))

# sep 함수를 통해 소괄호 공간을 없앤다.
print("<", ", ".join(temp), ">", sep="")
"""