def solution(nums):
    mon_num = len(nums)//2
    nums=list(set(nums))
    if len(nums)>=mon_num:
        answer = mon_num
    else:
        answer = len(nums)
    return answer
