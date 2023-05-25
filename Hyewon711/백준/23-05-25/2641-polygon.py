"""
   2641 - 다각형그리기

   1 : 오른쪽 2: 위쪽 3: 왼쪽 4: 아래쪽

    [입력]
   첫째 줄에는 다각형의 모양수열
   둘째 줄에는 그릴 모양수열의 개수
   셋째 줄부터는 개수만큼의 모양수열

   첫째 줄에 입력한 모양수열과 같은 형태의 모양수열들의 개수와 정보를 출력한다.
   같은 모양수열은 같은 방향으로 시작하는 경우와, 다른 방향으로 시작하는 수열 두 가지를 신경써야한다.

"""

import sys

num_moves = int(sys.stdin.readline())  # 표본 모양수열 길이
sample_form = list(map(int, sys.stdin.readline().split()))  # 표본 모양수열
num_shapes = int(sys.stdin.readline())  # 모양수열 갯수
shapes = []  # 모양수열 담을 리스트

for _ in range(num_shapes):
    shapes.append(list(map(int, sys.stdin.readline().split())))

# 1,3 / 2,4 매핑할 dict
reverse = {1:3, 2:4, 3:1, 4:2}
sames = []

for shape in shapes:
    reverse_shape = list(map(lambda x: reverse[x], shape))[::-1]  # 1,3 / 2,4 매핑 후 순서 뒤집기

    if shape == sample_form or reverse_shape == sample_form:
        sames.append(shape)
        continue

    for i in range(1, num_moves):
        tmp = shape[i:] + shape[:i]
        reverse_tmp = reverse_shape[i:] + reverse_shape[:i]
        if tmp == sample_form or reverse_tmp == sample_form:
            sames.append(shape)
            break

print(len(sames))
for s in sames:
    print(' '.join(list(map(str, s))))
