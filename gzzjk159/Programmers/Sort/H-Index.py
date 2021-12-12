def solution(citations):
    citations.sort()
    for idx in range(len(citations)):
        if citations[idx] >= len(citations) - idx: 
            return (len(citations) - idx)   
    return 0
