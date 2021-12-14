def solution(citations):
    # [0,1,3,5,6]
    # len = 5
    citations.sort()
    for idx , citation in enumerate(citations):
        if citation >= len(citations) - idx :
            return len(citations) - idx
    return 0
'''
1. 내림차순
def solution(citations):
    # [6,5,3,1,0]
    citations.sort(reverse=True)
    for idx , citation in enumerate(citations):
        if idx >= citation:
            return idx
    return len(citations)
2. 내가풀어보던거
def solution(citations):
    answer = []
    citations.sort()
    # [0,1,3,5,6]
    for i in range(len(citations)):
        if len(citations)-i>=i :
            answer.append(citations[i])
    return max(answer)

citations = [3,0,6,1,5]
print(solution(citations))
'''