"""

2422 - 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
아이스크림 종류 N, 섞어먹으면 안되는 조합의 개수 M
(1 ≤ N ≤ 200, 0 ≤ M ≤ 10,000)
- N의 값이 큰편이 아니다. 200C3으로 풀어도 시간초과는 나지않는다.
따라서 조합(Combination)하고 섞어먹으면 안되는 조합을
빼는 방향으로 구현하자.


"""

from itertools import combinations
n, m = map(int, input().split())
ice_cream = [[False]* n for _ in range(n)] # 기본값은 false, 조합하면 안되는 수를 아래 for문을 통해 True 바뀐다.

for i in range(m): # 조합하면 안되는 개수 m
    i1, i2 = map(int, input().split()) # 두번째 줄부터 입력받은 조합하면 안되는 짝들.
    ice_cream[i1-1][i2-1] = True
    ice_cream[i2-1][i1-1] = True # 짝이므로 1,2와 2,1 모두 False 바꿔주자.

result = 0

for i in combinations(range(n), 3): # 조합 nC3
    if ice_cream[i[0]][i[1]] or ice_cream[i[0]][i[2]] or ice_cream[i[1]][i[2]]:
        # 아이스크림 3가지를 선택해야한다. 0->1, 0->2, 1->2를 비교하여 모두 True 경우 경우의 수로 세지않는다.
        continue
    result += 1 # if문을 통해 continue가 실행되지 않은 경우 (만약 3가지가 모두 False 경우) 경우의 수로 센다.

print(result)