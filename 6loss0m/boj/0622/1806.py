# 부분합

N, S = map(int,input().split())
nums = list(map(int,input().split()))
left, right = 0, 0
total = nums[0]
ans = 100001

while True:
    if total == S: # 같을때
        total -= nums[left]
        ans = min(ans, right - left + 1)
        left += 1
    elif total > S: # 더 클때
        total -= nums[left]
        left += 1
    else: # 더 작을때
        right += 1
        if right == N:
            break
        total += nums[right]

print(0) if ans == 100001 else print(ans)


'''
시간초과
-> sum함수로 인한 시간초과 
left, right = 0, 1
while right<=N and left<=right:
    
    sum_nums = nums[left:right]
    total = sum(sum_nums)
    if total == S:
        ans.append(right-left)
        right += 1
    elif total < S:
        right += 1
    else:
        left += 1
        
print(min(ans))
'''