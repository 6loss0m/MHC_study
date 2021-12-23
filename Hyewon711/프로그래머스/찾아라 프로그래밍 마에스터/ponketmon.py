def solution(nums): #시간복잡도 O(1)
    answer = 0

    num = len(nums) // 2 #가져가는 폰켓몬 
    #가져가는 폰켓몬은 중복으로 가져가지 않는다.
    
    # set 함수 -> 중복되지 않은 원소(unique) 
    arr = list(set(nums))
    
    if len(arr) > num:
        # 배열의 길이가 뽑을 폰켓몬의 수보다 많을 경우
        answer = num
    else:
        answer = len(arr)

    return answer