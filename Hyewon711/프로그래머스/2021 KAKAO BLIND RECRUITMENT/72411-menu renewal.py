# 72411 - 메뉴 리뉴얼
# orders : 손님들이 주문한 단품 메뉴
# course : 코스요리를 구성하는 단품메뉴들의 갯수

import itertools
from collections import Counter

def solution(orders, course):
    answer = []

    for c in course : # 코스요리를 구성할 메뉴 갯수 반복
        temp = [] #
        for order in orders : # 손님들이 주문한 단품 메뉴 반복
            comb = itertools.combinations(sorted(order), c)
            # 현재 order의 문자열을 먼저 정렬한 후, c만큼 조합으로 만든다.
            # print(list(comb))
            temp += comb
            # 만들어진 조합을 temp에 리스트 추가

        my_dict = Counter(temp) # temp에 저장된 조합을 my_dict에 각각 조합이 얼마나 count 된지를 저장

        if len(my_dict) > 0 :
            max_dict = max(list(my_dict.values())) # count 된 조합이 저장된 리스트중 가장 큰 값을 먼저 저장
            if max_dict >= 2 : # 코스요리 메뉴는 최소 2가지 이상
                for key_, values_ in my_dict.items() : # 딕셔너리에 저장된 키, 값을 가져와서 반복
                    if values_ == max_dict : # 현재 비교하는 값이 max_dict과 동일하다면
                        answer.append(''.join(map(str, key_))) # 해당 키 값(알파벳 조합)을 answer에 저장

    answer = sorted(answer) # 저장된 키 값을 sort (사전 순으로 오름차순 정렬하여 return 해야하므로)
    return answer