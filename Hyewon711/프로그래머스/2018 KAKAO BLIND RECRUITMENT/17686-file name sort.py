# 17686 - 파일명 정렬
# 문자열은 대소문자 구분 X
# HEAD : 숫자가 아닌 문자열
# NUMBER : 1~5사이 연속된 숫자
# TAIL : 숫자가 올 수도, 아무 글자가 없을 수 있음
# 정규표현식 사용

import re
from collections import defaultdict
def solution(files):
    answer = []
    head = re.compile('^\D+') # 하나 혹은 그 이상 연결된 숫자
    number = re.compile('\d{1,5}') # 숫자만 허용, 5자리
    # tail = re.compile('^\D+\d{1,5}')

    file_dict = defaultdict(list)

    for file in files: # 입력 파일을 하나씩 반복
        upper_file = file.upper() # 대문자로 변경
        fhead = head.findall(upper_file)[0] # 정규표현식을 이용하여 head 추출, 첫번째 글자가 일치하는 문자열을 찾기
        fnumber = int(number.findall(upper_file)[0]) # 정규표현식을 이용하여 number 추출, number의 첫번째 글자가 일치하는 숫자를 찾고 모두 int(정수)로 변경
        # ftail = upper_file[tail.match(upper_file).end():]
        file_dict[file]+=[fhead,fnumber]  # 현재 파일에 위의 처리를 한 head와 number를 추가
        # 입출력 예제1의 경우 file_dict[file]은 아래의 결과와 같다
        """ ['IMG', 10]
            ['IMG', 2]
            ['IMG', 1]
            ['IMG', 1]
            ['IMG', 2]"""

    # items()는 Key와 Value의 쌍을 튜플로 묶은 값
    print(*file_dict.items())
    file_dict = sorted(file_dict.items(), key = lambda item: (item[1][0],item[1][1]))
    # head와 number로 쪼갠 파일명을 이용해 head를 기준으로 정렬하고 둘이 같다면 number를 비교
    # head와 number 모두 같은 경우 그대로 정렬하므로 입력한 순으로 정렬된다.

    for file in file_dict: # file_dict에 값을 answer에 추가
        answer.append(file[0])

    return answer