# BOJ 1759 - 암호 만들기
# 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15)
from itertools import combinations

l, c = map(int, input().split())
alphabet = list(map(str, input().split())) # str로 문자열 입력받기 -> lits에 넣음
alphabet.sort() # 알파벳은 오름차순으로 sort해준다.

vowels = ['a', 'e', 'i', 'o', 'u'] # 최소 한 개의 모음(a, e, i, o, u)이 포함되어야한다.
for ans in combinations(alphabet, l): # 문자열 리스트 alphabet, l개만큼 조합한 ans
    vowel = 0 # 모음의 개수를 더할 변수
    for i in range(len(ans)):
        if ans[i] in vowels: # 모음이 포함된 경우
            vowel += 1
    if l-2 >= vowel >= 1 : # 자음은 최소 2개이므로 l-2 >= 모음의 개수 >= 1 로 조건을 둔다.
        print(''.join(map(str, ans))) # 문자 사이를 join으로 붙여주기