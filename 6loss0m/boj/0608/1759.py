# 암호만들기
# 암호는 무조건 정렬되어 있다.
# 4 6
# a t c i s w
# -> a c i s t w
# L = 4, C = 6
# s = [a, c, i, s, t, w]
import sys
input = sys.stdin.readline
def dfs(len, idx):
    if len == l: # 1차 암호 조건(길이)
        vo = 0 # 모음개수
        co = 0 # 자음개수
        for i in range(l):
            if arr[i] in 'aeiou': vo += 1
            else: co += 1
        if vo >= 1 and co >= 2: # 2차 암호 조건(모음, 자음)
            print(''.join(arr)) # 출력
        return
    for i in range(idx, c): # 0, 6 : 0~5 / 1, 6
        if check[i] == 0: # 아직 방문하지 않았을 경우
            arr.append(s[i])
            check[i] = 1 # 방문 체크
            dfs(len + 1, i + 1) # 다음 문자열 확인 # 1 1
            check[i] = 0 # 확인한애들 지워주기
            del arr[-1] # 자리제거
    # 팁 : dfs 인자로 'a', 'ac', 'aci', ... string 주고받기
l, c = map(int, input().split())
check = [0 for i in range(c)]
arr = []
s = input().split()
s.sort()
dfs(0, 0)


# 조합 이용
from itertools import combinations

L, C = map(int,input().split())
alpha = sorted(input().split())
words = combinations(alpha, L)

for word in words:
    cnt_vow = 0
    for i in word:
        if i in "aeiou":
            cnt_vow += 1
    # 전체 - 모음 = 자음
    if cnt_vow >=1 and L - cnt_vow >=2:
        print(str(word))
        #print(''.join(word))