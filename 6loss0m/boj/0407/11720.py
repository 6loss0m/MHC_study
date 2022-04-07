# 숫자의 합
n = int(input())
nums = int(input())
sum = 0
# n개 만큼만 하는것도 나쁘지 않을듯...
while nums:
    sum = sum + (nums%10)
    nums = nums//10
print(sum)