import sys

a,b = map(int, sys.stdin.readline().strip().split())
n = int(sys.stdin.readline().strip())
num_list = list(map(int, sys.stdin.readline().strip().split()))

b_list = []

deci = 0
idx = 0

for i in range(n-1,-1,-1):
    deci += num_list[idx]*(a**i)
    idx += 1


while deci: #n진수 나눠서 숫자 만들기
    b_list.append(deci%b)
    deci = deci // b


b_list = list(reversed(b_list)) # 뒤집기
print(*b_list)