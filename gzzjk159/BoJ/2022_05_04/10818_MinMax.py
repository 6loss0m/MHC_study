import sys

n = int(sys.stdin.readline().strip())

num_list = list(map(int, sys.stdin.readline().strip().split()))
print(min(num_list), max(num_list))
