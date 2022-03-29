import sys
n = int(input())
num_list = []
for _ in range(n):
    num_list.append(int(sys.stdin.readline()))

for num in sorted(num_list):
    print(num)