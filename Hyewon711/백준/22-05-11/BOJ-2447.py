# BOJ 2447 별찍기 - 10
# https://cotak.tistory.com/38
import sys
input = sys.stdin.readline

n = int(input())

def draw_stars(n):
    if n==1:
        return ['*']

    Stars = draw_stars(n//3)
    print(Stars)
    L=[]

    for star in Stars:
        L.append(star*3)
    for star in Stars:
        L.append(star+' '*(n//3)+star)
    for star in Stars:
        L.append(star*3)

    return L
# 총 3개의 for문을 ['*']로 돌렸을 때
# L의 결과는 ['***', '* *', '***'] 이 된다.
# '*' 한개의 요소가 아닌 한 덩어리로 생각하기

print('\n'.join(draw_stars(n)))