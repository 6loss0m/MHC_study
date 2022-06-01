# BOJ 1963 - 소수 경로
# 에라토스테네스의 체로 1000 이상 10000미만의 소수를 모두 구한 후 미리 저장한다.
import sys, heapq

def getPrime(arr):  # 9999까지 미리 소수여부를 저장

    for i in range(2,10000):
        if arr[i]:  #소수이면, r의 배수는 모두 소수가 아님
            for j in range(i*2, 10000, i):
                arr[j] = False

    for i in range(1000):   # 1000보다 작으면 안됨.
        arr[i] = False

### MAIN
N = int(sys.stdin.readline())

arr = [True for _ in range(10000)] # 0~999까지 소수 여부를 저장하는 배열
getPrime(arr)

for _ in range(N):
    num1, num2 = sys.stdin.readline().strip().split()

    vi = [False for _ in range(10000)]

    que = []
    heapq.heappush(que, (0, num1))

    res = 'Impossible'
    while que:
        cnt, num = heapq.heappop(que)
        if ''.join(num) == num2:
            res = cnt
            break;

        for i in range(4):
            for j in range(10):
                chgNum = list(num)
                chgNum[i] = str(j)
                intNum = int(''.join(chgNum))
                if arr[intNum] and not vi[intNum]: # 소수이고 방문하지 않은 경우,
                    heapq.heappush(que, (cnt+1, chgNum))
                    vi[intNum] = True
    print(res)