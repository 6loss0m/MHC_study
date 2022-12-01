"""

5568 - 카드 놓기
카드 장수 n개, 카드 선택 k개
(2 ≤ k 4 ≤ n ≤ 10)
순열문제이다. 순서대로 나열하는 수에 따라 한 정수를 만드는 조합이 정해진다.
값은 10P4가 최대이고, 이는 n!/(n-r)! 이므로 3628800/720 = 504이 최대 경우의 수이다.


"""

from itertools import permutations

n = int(input()) # 첫째 줄
k = int(input()) # 두번째 줄
card = [input().rstrip() for _ in range(n)] # 카드에 적혀있는 수
number = set() # 순열로 구하므로 중복은 불가능, set으로 선언한다.

for i in permutations(card, k): # 카드에 적혀있는 수에서 k개만큼 뽑아 순열을 만든다.
    number.add(''.join(i)) # 뽑은 카드를 뽑은 순서대로 나열하여 한 정수를 만든다.

print(len(number)) # 만든 정수의 개수를 세어 print