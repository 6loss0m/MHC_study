# DFS - 조건문 / 재귀함수 / 완전탐색
def solution(numbers, target):
    cnt = 0
    
    def dfs(numbers, target, idx=0): #numbers, target, 인덱스 번호
        if idx < len(numbers): #numbers 길이만큼 반복
            numbers[idx] *= 1
            dfs(numbers, target, idx+1)
            
            
            numbers[idx] *= -1
            dfs(numbers, target, idx+1)
            
        elif sum(numbers) == target:
            nonlocal cnt
            cnt += 1

    dfs(numbers, target)

    return cnt