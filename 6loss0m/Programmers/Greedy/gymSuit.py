def solution(n, lost, reserve):
    reserve_list = [r for r in reserve if r not in lost]
    lost_list = [l for l in lost if l not in reserve]
    reserve_list.sort()
    lost_list.sort()
    for r in reserve_list:
        f = r - 1
        b = r + 1
        if f in lost_list:
            lost_list.remove(f)
        elif b in lost_list:
            lost_list.remove(b)
    print(lost_list)
    print(n-len(lost_list))
    return n - len(lost_list)
'''
5, [2, 4], [5, 3]

위의 경우는 체육복을 잃어버린 학생들 앞 뒤로 모두 여벌의 체육복이 있는 경우입니다.
여벌 체육복을 가진 학생들의 번호가 순서대로 들어오지 않는 경우를 해결하면 됩니다.
'''