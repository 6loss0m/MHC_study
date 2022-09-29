# 72412 - 순위 검색
# 정확성은 쉽게 가능하나 효율성에서 떨어지는 경우가 다수
# 몇점 이상의 사람을 찾는 과정을 이진탐색해야 효율성 통과

from collections import defaultdict
from itertools import combinations

def solution(info, query):
    answer = []
    # 지원자가 속할 수 있는 모든 조건 : key
    # 해당 조건에 속하는 지원자들의 점수 : value
    infos = defaultdict(list) # 처음 키를 지정할 때 값을 주지 않으면 해당 키에 대한 값을 기본 값으로

    for i in info :
        conditions = i.split()[:-1] # 코테점수 제외 조건
        score = int(i.split()[-1]) # 가장 끝에 저장된 값 (코테 점수)

        for j in range(5): # 조건이 4개, 코딩테스트 점수 1개로 총 5개
            comb = list(combinations(range(4), j))
            # '-'로 바꿀 경우의 수
            for c in comb : # 각 경우의 수에 대해 '-'로 바꾼 조건 생성
                test_case = conditions[:] # conditions의 리스트 전체를 가져오기
                for v in c :
                    test_case[v] = '-'
                    # print(test_case)
                infos['_'.join(test_case)].append(score)
    for item in infos:
        infos[item].sort()

    for q in query :
        q = q.replace('and', '').split() # query의 and, ''를 기준으로 나누기
        conditions = '_'.join(q[:-1]) # 나눠진 q를 코테 점수만 빼고 모두 _로 붙이기
        # print(conditions)
        score = int(q[-1]) # 코테점수는 q의 가장 마지막 부분

        if conditions in list(infos):
            data = infos[conditions]
            if len(data) > 0 :
                start, end = 0, len(data) # 이분탐색
                while start != end and start != len(data) : # 중간값과 score를 if문으로 확인하며 반복
                    if data[(start + end) // 2] >= score :
                        end = (start + end) // 2
                    else :
                        start = (start + end) // 2 + 1
                answer.append(len(data)-start) # 이분탐색으로 얻어진 결과값 answer에 추가
        else :
            answer.append(0)

    return answer