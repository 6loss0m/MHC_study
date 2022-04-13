import sys
from collections import deque
n,k = map(int, sys.stdin.readline().rstrip().split())
dq = deque([i for i in range(1, n+1)])
ans = []
while dq:
    dq.rotate(-k+1)
    ans.append(str(dq.popleft()))
sys.stdout.write("<"+', '.join(ans)+">")