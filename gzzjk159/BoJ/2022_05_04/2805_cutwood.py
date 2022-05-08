import sys

input = sys.stdin.readline

n , m = map(int, input().strip().split())
tree = list(map(int, input().strip().split()))
start , end = 1, max(tree)

while start <= end:
    mid = (start + end)//2
    wood = 0
    for i in tree:
        if i >= mid:
            wood += i -mid
    if wood>=m:
        start = mid + 1
    else:
        end = mid -1
print(end) #pypy3에서만 정답 됨
# sys.stdout.write(str(end))    #python3에서도 정답 됨