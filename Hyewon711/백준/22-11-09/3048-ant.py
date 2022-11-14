# 3048 - 개미
import sys

n1, n2 = map(int, sys.stdin.readline().split()) # 첫 번째 그룹 개미 n1, 두 번째 그룹 개미 n2
ant1 = list(map(str, sys.stdin.readline().rstrip("\n"))) # 1그룹
ant2 = list(map(str, sys.stdin.readline().rstrip("\n"))) # 2그룹
t = int(sys.stdin.readline()) # T초
ant1.reverse()
ans = ant1 + ant2 # 두 그룹이 마주보고 좁은 길을 간다

for _ in range (t) :
    for i in range(len(ans)-1) :
        if ans[i] in ant1 and ans[i+1] in ant2 : # 만약 서로 마주보는 상태인 경우
            ans[i], ans[i+1] = ans[i+1], ans[i] # 둘을 바꿔준다.

            if ans[i+1] == ant1[-1]: # 더이상 바꿀 자리가 없는 경우에도 break
                break

print("".join(ans))