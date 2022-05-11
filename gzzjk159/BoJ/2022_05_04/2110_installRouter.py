import sys
input = sys.stdin.readline
n ,c =  map(int, input().strip().split())
house = [int(input().strip()) for _ in range(n)]
house.sort()

start = 1
end = house[-1] - house[0]

result = 0

while start <= end:
    mid = (start+end)//2
    ins = house[0]
    count = 1

    for i in range(1, len(house)):
        if house[i] >= ins + mid:
            count += 1
            ins = house[i]
    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)