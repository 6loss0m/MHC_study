# 68936 - 쿼드압축 후 개수 세기

def press(x, y, arr, n, one, zero): # x좌표, y좌표, 2차원 정수 배열, 1의 개수, 0의 개수
    default = arr[x][y]
    flag = True

    for i in range(n):
        for j in range(n):
            if default != arr[x+i][y+j]: # 현재의 좌표와 비교하는 좌표가 다른 경우
                flag = False # 압축이 불가능 (False)
                break

    if flag == True : # 압축이 가능한 경우
        if default == 0: # 0이라면
            zero += 1 # 0으로 압축, 1개 카운트
        else:
            one+= 1 # 1이라면 1로 압축, 1개 카운트

    else:
        n = n//2 # 배열의 길이의 절반 
        zero, one= press(x, y, arr, n, one, zero) # 남서 사분면
        zero, one = press(x, y+n, arr, n, one, zero) # 북서 사분면
        zero, one = press(x+n, y, arr, n, one, zero) # 남동 사분면
        zero, one = press(x+n, y+n, arr, n, one, zero) # 북동 사분면

    return zero, one # 카운트된 0과 1의 개수를 리턴


def solution(arr):
    return press(0, 0, arr, len(arr), 0, 0)