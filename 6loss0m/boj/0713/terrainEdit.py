# 지형 편집
def solution(land, P, Q):
    lst = []
    for i in land:
        lst += i
    lst = sorted(lst)

    n = len(lst)
    answer = sum(lst)*Q
    cost = (sum(lst) - lst[0]*n )*Q
    answer = min(answer, cost)

    for i in range(1, n):
        if lst[i] != lst[i-1]:
            cost += (P * i * (lst[i]-lst[i-1])) - (Q * (n-i) * (lst[i]-lst[i-1]))

            answer = min(answer, cost)
    return answer