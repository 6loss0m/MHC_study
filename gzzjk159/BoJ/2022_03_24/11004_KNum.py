n, k = map(int, input().split())
n_list = list(map(int, input().split()))
n_list.sort()
print(n_list[k-1])