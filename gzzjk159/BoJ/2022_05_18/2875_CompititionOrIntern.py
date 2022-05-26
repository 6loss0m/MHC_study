import sys
input = sys.stdin.readline
n, m, k = map(int , input().strip().split())

def team(g,b):
    i = g//2
    return min(i,b)

answer = team(n-k,m)

for i in range(k+1):
    answer = max( answer, team(n-(k-i),m-i))
print(answer)