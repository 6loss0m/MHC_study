import sys

input = sys.stdin.readline

n = int(input().strip())

mr_list = []

for i in range(n):
    a,b = map(int , input().strip().split())
    mr_list.append([a,b])

mr_list.sort(key = lambda x:(x[1], x[0]))

answer = 1
end_time = mr_list[0][1]

for i in range(1,n):
    if mr_list[i][0] >= end_time:
        answer +=1
        end_time = mr_list[i][1]

print(answer)