# 12982 - 예산
# 최대로 지원하기 위해서 예산이 가장 적게 드는 부서부터 총 예산에서 차례대로 뺀다.

def solution(d, budget):
    answer = 0
    for i in sorted(d):
        budget -= i
        if budget < 0: # 0보다 작으면 break
            break
        answer += 1

    return answer