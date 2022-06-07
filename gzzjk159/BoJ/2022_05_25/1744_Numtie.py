import sys

input = sys.stdin.readline

n = int(input().strip())
num_list = []

for _ in range(n):
    num_list.append(int(input().strip()))
num_list.sort()
answer = 0

while len(num_list) > 1 and num_list[-2]>1: # 양수 부분
    answer += num_list[-1] * num_list[-2]
    num_list.pop()
    num_list.pop()

while num_list and num_list[-1]>0: #양수면서 1인 부분
    answer += num_list[-1]
    num_list.pop()

while len(num_list) > 1 and num_list[1]<=0: # 음수 부분
    answer += num_list[0] * num_list[1]
    num_list.pop(0)
    num_list.pop(0)

if num_list:
    answer += num_list[0]

print(answer)