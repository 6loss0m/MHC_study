"""
문제 시간을 보니 0.3초 라는 짧은 시간
O(n)을 가진 위에 코드로는 풀기 어려움
그래서 O(1)같은 시간 복잡도를 가진 코드를 짜야한다
그러기 위해선 stack같이 pop, append같은 함수를 이용해야한다.
여기서 적용하기위해선 stack을 두 개 이용하는 것이 핵심이라고 생각한다.
이 생각을 가지고 코드를 다시 짜야한다.
이걸 생각한 사람들이 대단하다
"""
import sys
str = list(sys.stdin.readline().rstrip())
n = int(sys.stdin.readline().rstrip())
str2 = []
for i in range(n):
    com = sys.stdin.readline().rstrip().split()
    if com[0]=="P":
        str.append(com[1])
    elif com[0]=="L":
        if str:
            str2.append(str.pop())
        else:
            continue
    elif com[0] == "D":
        if str2:
            str.append(str2.pop())
        else:
            continue
    else:
        if str:
            str.pop()
        else:
            continue
print("".join(str + list(reversed(str2))))
# cursor = len(str)
# print(str[0])
# for i in range(n):
#     com = sys.stdin.readline().rstrip().split()
#     if com[0]=="L":
#         if cursor>0:
#             cursor -= 1
#     elif com[0]=="D":
#         if cursor<len(str):
#             cursor += 1
#     elif com[0]=="B":
#         if cursor>0:
#             str.remove(str[cursor-1])
#     else:
#         str.insert(cursor, com[1])
#         cursor += 1
# print("".join(str)) 시간 초과


