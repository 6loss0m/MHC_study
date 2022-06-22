# 로또
# 각 테스트케이스로 입력받는것들은 list형태로 입력받아 index로 조작
from itertools import combinations

while True:
    n = list(map(int,input().split()))
    if n[0] == 0:
        break
    lotto = list(combinations(n[1:],6))
    for i in lotto:
        for j in i:
            print(j, end=' ')
        print()
    print()
