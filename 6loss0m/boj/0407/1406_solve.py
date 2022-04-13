# 에디터
import sys
# 문자열 입력
st1 = list(sys.stdin.readline().rstrip())
st2 = []
# 커서를 기준으로 왼쪽 st1, 오른쪽 st2
# n만큼 명령어 입력
for _ in range(int(sys.stdin.readline())):
    command = list(sys.stdin.readline().split())
    if command[0] == 'L':
        if st1:
            st2.append(st1.pop())
    elif command[0] == 'D':
        if st2:
            st1.append(st2.pop())
    elif command[0] == 'B':
        if st1:
            st1.pop()
    else:
        st1.append(command[1])
st1.extend(reversed(st2))
# st2.reverse()사용시 st2값이 존재하지 않는다면 TypeError를 띄움
# reversed(st2)는 값이 존재하지 않더라도 오류 x
print(''.join(st1))