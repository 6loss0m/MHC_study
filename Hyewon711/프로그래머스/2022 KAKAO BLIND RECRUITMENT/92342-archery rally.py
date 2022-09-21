# 92342 - 양궁대회

from copy import deepcopy

max_diff = 0
answer = []

def dfs(info, shoot, n, i) :
    global answer, max_diff
    if i == 11 : # 재귀하다가 i == 11이 되면 info, shoot의 점수 차 구하기
        if n != 0 : # 점수 차이가 0이 아니라면
            shoot[10] = n
        score_diff = calcDiff(info, shoot)
        if score_diff <= 0 : # 점수 차이가 0과 같거나 작다면
            return # 그대로 return
        result = deepcopy(shoot) # shoot 리스트를 result에 복사
        if score_diff > max_diff : # 현재 점수 차이가 max_diff보다 크면
            max_diff = score_diff # 갱신
            answer = [result] # 정답에 [result] 담기
            return

        if score_diff == max_diff : # 둘이 같다면
            answer.append(result) # answer에 result 추가
        return

    # 어피치가 맞힌 과녁의 각 개수를 하나씩 확인, 그 값이 n보다 작을 경우
    if info[i] < n :
        shoot.append(info[i] + 1) # shoot은 라이언이 각 과녁을 맞힌 개수
        dfs(info, shoot, n-info[i]-1, i + 1) # info[i]+1을 추가한 후 재귀
        shoot.pop()

        # 만약 점수를 먹지 않은 경우엔 shoot에 0을 추가, 재귀
    shoot.append(0)
    dfs(info, shoot, n, i + 1)
    shoot.pop()

def calcDiff(info, shoot) : # 점수 차이를 구하는 calcDiff 함수
    enemyScore, myScore = 0, 0 # 어피치 획득 점수, 라이언 획득 점수
    for i in range(11) : # 0~10 반복문
        if (info[i], shoot[i]) == (0, 0) : # 둘다 점수를 획득할 수 없다면
            continue
        if info[i] >= shoot[i] : # 어피치가 라이언보다 맞힌 개수가 많으면
            enemyScore += (10 - i) # 어피치에 누적
        else : # 라이언이 맞힌 개수가 많으면
            myScore += (10 - i) # 라이언에 누적

    return myScore - enemyScore


def solution(n, info) :
    global answer, max_diff
    dfs(info, [], n, 0) # dfs로 가장 큰 점수차로 우승하기 위한 리스트 받기
    if answer == [] : # 리스트가 빈 경우 -1 리턴
        return [-1]

    answer.sort(key=lambda x: x[::-1], reverse=True)
    # 가장 낮은 점수를 맞힌 개수가 더 많은 순으로 정렬
    return answer[0] # 첫 번째 리스트 반환