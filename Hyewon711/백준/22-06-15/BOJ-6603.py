# BOJ 6603 - 로또
from itertools import combinations
ans = list()

while True:
    s = list(map(int, input().split()))
    if s[0] == 0: # 0을 입력받은 경우 break
        break
    ans.append(list(combinations(s[1:], 6))) # 숫자 개수를 나타내는 맨 앞 숫자는 제외

for i in range(len(ans)):
    for j in ans[i]:
        print(' '.join([str(k) for k in j]))
    print()