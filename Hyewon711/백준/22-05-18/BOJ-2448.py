# BOJ 2448 - 별찍기 - 11
# https://lcyking.tistory.com/93?category=972936
# 위 링크는 *, * *, *****를 그리지않고 수학적으로 푼 답안
# https://hongcoding.tistory.com/90
#   *
#  * *
# *****

n = int(input())

def star(l):
    if l == 3: # l == 3인경우 아래 별탑을 리턴
        return ['  *  ',' * * ','*****']

    arr = star(l//2)
    stars = []
    for i in arr:
        stars.append(' '*(l//2)+i+' '*(l//2))

    for i in arr:
        stars.append(i + ' ' + i)

    return stars

print('\n'.join(star(n)))