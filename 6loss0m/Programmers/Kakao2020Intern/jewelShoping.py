from collections import defaultdict


def solution(gems):
    gdict = defaultdict(int)
    gnum = len(set(gems))

    left = 0
    right = 0
    answer = [0, len(gems)]
    
    while right < len(gems):
        # 변수[보석명] = 개수
        gdict[gems[right]] += 1
        right += 1
        # 모든 보석을 구매한 경우
        if len(gdict) == gnum:
            # 최소 경우로 축소
            while left < right:
                if gdict[gems[left]] <= 1:
                    break
                gdict[gems[left]] -= 1
                left += 1

            # len(gems) + 1 - 0 > right - left
            # 최소값 변경
            if answer[1]+1-answer[0] > right - left:
                answer = [left+1, right]

    return answer