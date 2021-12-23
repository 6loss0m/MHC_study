def solution(nums):
    answer = 0
    length = len(nums) // 2
    temp = list(set(nums))
    
    if length < len(temp):
        answer = length
    else:
        answer = len(temp)
            
    return answer