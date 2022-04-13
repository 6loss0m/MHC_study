import sys

line = list(sys.stdin.readline().strip())
n = int(sys.stdin.readline())
#print(line)
cur = len(line)
for i in range(n):
    op = sys.stdin.readline().split()
    if op[0] == 'L':
        if cur != 0:
            cur -= 1
    elif op[0] == 'D':
        if cur != len(line):
            cur += 1
    elif op[0] == 'B':
        if cur != 0:
            del line[cur-1]
            cur -= 1
    elif op[0] == 'P':
        line.insert(cur,op[1])
        cur += 1
    # 디버깅
    '''
    print(line,cur)
    for i in range(len(line)+1):
        if cur == i:
            print('[*]',end='')
        else:
            print('[ ]',end='')
    print()
    '''
print("".join(line))