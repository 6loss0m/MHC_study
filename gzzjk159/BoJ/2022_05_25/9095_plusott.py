import sys
input = sys.stdin.readline


def plusott(num ,total):
    global answer
    if total >= n:
        return
    total += num
    if total == n:
        answer += 1
    plusott(1, total)
    plusott(2, total)
    plusott(3, total)


t = int(input())
for _ in range(t):
    n = int(input())
    answer = 0
    plusott(0,0)
    print(answer)