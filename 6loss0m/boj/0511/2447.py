# 별 찍기 - 10
# 27 9 3 1
def draw_stars(n):
    if n==1:
        return ['*']

    Stars=draw_stars(n//3)
    L=[]

    for star in Stars:
        L.append(star*3)
    for star in Stars:
        L.append(star+' '*(n//3)+star)
    for star in Stars:
        L.append(star*3)

    return L

N=int(input())
print('\n'.join(draw_stars(N)))