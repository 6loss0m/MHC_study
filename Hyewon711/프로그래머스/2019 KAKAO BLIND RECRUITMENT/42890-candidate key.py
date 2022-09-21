# 42890 - 후보키
from itertools import combinations

def solution(relation):
    len_key = len(relation[0])
    candidate_key = []
    for i in range(1, len_key + 1):
        for combi in combinations(range(len_key), i):  # 후보키가 될수 있는 key들의 전체 조합 찾기
            temp = list()
            for r in relation:
                curr = [r[c] for c in combi]  # 현재 후보키 조합에 해당하는 튜플(행) 데이터
                if curr in temp:  # 유일성을 만족하지 않는 경우
                    break
                else:
                    temp.append(curr)
            else: # for - else : break 없이 빠져나온 경우 else문 실행
                for ck in candidate_key: # 후보키 검사
                    if set(ck).issubset(set(combi)):  # 최소성을 만족하지 않는 경우
                        # issubset : ck가 combi의 서브 set이 맞는가? (포함하는가?)
                        break # True라면 break
                else:
                    candidate_key.append(combi) # 아닌 경우 후보키가 된다
    return len(candidate_key) # 후보키의 개수