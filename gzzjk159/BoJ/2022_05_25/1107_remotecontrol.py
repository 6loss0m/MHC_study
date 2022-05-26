target = int(input())
ans = abs(100 - target) # ++ or -- 로 이동할 경우 -> 최댓값
M = int(input())
if M: # 고장난게 있을 경우만 인풋을 받음
    broken = set(input().split())
else:
    broken = set()

# 작은수에서 큰수로 이동할땐 500,000 까지만 보면 되지만
# 반대로 큰수에서 작은수로 내려올수도 있으므로 1,000,000 까지 봐야함
for num in range(1000001):
    for N in str(num):
        if N in broken: # 해당 숫자가 번호를 눌러서 만들 수 없는 경우엔 스탑
            break
    else: # 번호를 눌러서 만들 수 있는 경우엔 # min(기존답, 번호를 누른 횟수 + 해당 번호로부터 타겟까지의 차이)
        ans = min(ans, len(str(num)) + abs(num - target))
print(ans)