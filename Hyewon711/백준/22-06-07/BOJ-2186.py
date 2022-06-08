# BOJ 2186 - 문자판
# 반드시 한 칸 이상 이동, 같은 자리에 머물러 있을 수 없고 같은 칸 여러번 방문 가능
from sys import stdin

def dfs(loc, idx) :
    global ans
    x, y = loc

    # 1) 이미 체크한 경우 // 이미 체크한 경우의 수라면 해당 경우의 수를 체크하지 않아야 시간초과 X
    if  check[x][y][idx] != -1 :
        return check[x][y][idx]

    # 2) word 문자와 일치하지 않는 경우 // 이미 체크한 경우의 수라면 해당 경우의 수를 체크하지 않아야 시간초과 X
    if alpabet[x][y] != word[idx] :
        check[x][y][idx] = 0
        return 0

    # 3) word 문자와 일치
    if idx == len(word) - 1 :
        return 1

    cur_ans = 0
    for K in range(-k, k+1) :
        if not K : #
            continue

        next_x, next_y = x+K, y+K # 다음 좌표

        if 0 <= next_x < n : # 0~n-1 범위 내라면 행 확인
            cur_ans += dfs((next_x, y), idx+1) # 확인 후 idx 값을 1로 변경
        if 0 <= next_y < m : # 0~m-1 범위 내라면 열 확인
            cur_ans += dfs((x, next_y), idx+1) # 확인 후 idx 값을 1로 변경

    check[x][y][idx] = cur_ans # for문을 돈 후 cur_ans에 저장된 값이 word를 완성하는 경로가 된다.

    return check[x][y][idx]


input = stdin.readline
n, m, k = map(int, input().split()) # N * M (N개 줄에 M개의 대문자 알파벳) , 갈수있는 칸 K개
# direction = ((0, 1), (0, -1), (-1, 0), (1, 0)) # 상하좌우 자표
# 상하좌우 비교-> 시간초과, 방향을 접근할 때, next_x, next_y에 따라 두 가지의 가지로 뻗는 경우로 푸는 것이 더 효율적
ans = 0
alpabet = [ input().strip() for _ in range(n)] # N개줄의 알파벳 입력
word = input().strip() # 경로 개수를 확인할 단어 word
check = [[[-1] * len(word) for _ in range(m)] for _ in range(n)] # 3차원 배열을 만들기, 방문하지 않은 상태는 -1

for i in range(n):
    for j in range(m):
        if alpabet[i][j] == word[0] : # word의 첫번째 문자가 같은 경우 해당 위치에서 dfs 실행
            ans += dfs((i,j ), 0) # 모든 좌표를 돌때까지 반복하여 return 된 경로가 있을때마다 ans에 1 추가

print(ans) # 저장된 경로의 수 출력
