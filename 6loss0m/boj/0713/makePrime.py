from itertools import combinations

def prime(n):
    cnt = 0
    for i in range(2,n):
        if n%i == 0:
            cnt += 1
    if cnt == 0:
        return 1
    return 0

nums = [1,2,7,6,4]
cnt = 0
result = list(combinations(nums,3))

for i in result:
    if prime(sum(i)) == 1:
        cnt += 1

print(cnt)