def solution(array, commands):
    def com(arr, a, b, c):
        arr = arr[a-1:b] 
        arr.sort()
        return arr[c-1]
    answer = [] 
    for x, y, z in commands:
        answer.append(com(array, x, y, z)) 
    return answer