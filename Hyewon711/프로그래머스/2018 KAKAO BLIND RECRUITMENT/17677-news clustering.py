# 17677 - 뉴스 클러스터링
# 자카드 유사도 : 0과 1 사이의 값을 가지며, 두 집합이 동일하면 1, 공통의 원소가 하나도 없으면 0

# 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다.
# 따라서 set을 사용하면 오답이 나올 수 있다.
# 0~1 사이의 실수에 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.

# https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
# 해설 보러가기 참고

from collections import Counter
def solution(str1, str2):

    # upper : 대문자로 변경 함수, isalpha : 알파벳 확인 함수
    # 만약 str1, str2가 문자가 맞다면 upper()로 모두 대문자로 만들어주기, 두 글자씩 끊어야하므로 [i:i+2]이다.
    arr1 = [str1[i:i+2].upper() for i in range(len(str1) - 1) if str1[i:i+2].isalpha()]
    arr2 = [str2[i:i+2].upper() for i in range(len(str2) - 1) if str2[i:i+2].isalpha()]

    if len(arr1) == 0 and len(arr2) == 0:     # arr1 과 arr2가 공집합일경우
        return 65536 # 동일하므로 65536 출력

    c1 = Counter(arr1) # Counter : 해당 배열의 모든 원소의 갯수를 세기
    c2 = Counter(arr2)

    sum_set = sum((c1 | c2).values()) # key-value 중 value 값으로 구한 합집합 (or)
    inter_set = sum((c1 & c2).values()) # 교집합 (and)

    answer = int(inter_set / sum_set * 65536) # 교집합 / 합집합 * 65536이 정답
    return answer
