# BOJ 1992 - 쿼드트리
# 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고,
# 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 4개의 영상으로 나누어 압축
import sys
input = sys.stdin.readline

n = int(input()) # 영상의 크기를 나타내는 숫자 N
video = [ list(input().strip()) for _ in range(n) ] # 길이 N의 문자열이 N개

def cut(x, y, n):
    ans = []
    check = True
    black = video[x][y]

    for i in range(x, x+n):
        if not check: # 만약 check가 False 라면 break
            break
        for j in range(y, y+n):
            if black != video[i][j]: # 같지 않은경우 재귀
                check = False
                ans.append("(") # 분할 시작할 때 '(' 추가
                ans.extend(cut(x, y, n//2)) # append는 리스트 안에 리스트를 추가
                ans.extend(cut(x, y+n//2, n//2)) # extend는 확장의 의미로 한 리스트 안에 요소만 추가
                ans.extend(cut(x+n//2, y, n//2))
                ans.extend(cut(x+n//2, y+n//2, n//2))
                ans.append(")") # 분할을 마칠 때 ')' 추가
                return ans
    return black

print("".join(cut(0, 0, n)))
