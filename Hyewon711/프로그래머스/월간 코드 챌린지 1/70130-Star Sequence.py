# 70130 - 스타 수열

from collections import Counter
def solution(a):
    # a 배열 element 각 원소의 등장횟수를 센다.
    elements = Counter(a)
    # Counter의 출력값으로는 {'1':2, '2':3..} 과 같이 항목의 수를 나타낸다.
    answer = -1

    # a에 있는 각 원소 k를 기준으로
    # k값을 기준으로 스타수열을 만들 수 있는지 검증한다.
    for k in elements.keys():
        # k의 등장횟수가 스타수열에 사용된 공통인자 횟수보다 작거나 같으면
        # 더 계산할 필요가 없다.
        if elements[k] <= answer:
            continue
        common_cnt = 0
        idx = 0
        while idx < len(a)-1:
            # 조건에 만족하지 않을 경우, 다음 idx로 넘어간다.
            # - a[idx]와 a[idx+1] 둘 다 k가 없는 경우: 공통값 k가 없음
            # - a[idx] == a[idx+1]인 경우: 조건에 위배
            if (a[idx] != k and a[idx+1] != k) or (a[idx] == a[idx+1]):
                idx += 1
                continue
            # 스타수열 원소로 추가할 수 있는 경우, k 원소가 사용된 횟수를 1 증가시킨다
            common_cnt += 1
            # 다음 배열 탐색을 위해서는, idx를 2 증가시켜야 한다.
            idx += 2

        # 스타수열 완성을 위해 공통원소 k가 사용된 횟수 최댓값을 구한다.
        answer = max(common_cnt, answer)


    if answer == -1:
        return 0
    else:
        # 공통원소가 answer만큼 사용됐으면, 실제 배열의 길이는 2배.
        return answer * 2