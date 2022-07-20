# 49993 - 스킬트리
# 선행 스킬 순서가 있기에 특정 스킬을 배우려면 먼저 배워야하는 스킬이 필요하다.
# 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
# 중간에 다른 스킬배워도 괜찮지만, 선행스킬을 먼저 배워야하는건 스킬트리 짜는데에 필수 !

def solution(skill, skill_tree): # 선행 스킬 순서 skill, 유저들이 만든 skill tree
    answer = 0
    for i in skill_tree: # 스킬 트리에 저장된 스킬로 반복문 돌리기
        slist = '' # 스킬을 저장할 리스트,스킬트리가 가능한지 확인할 용도
        for j in i:  # 반복문 돌리는 스킬트리의 요소 하나씩 확인하기 (BACDE중 B부터~)
            if j in skill: # 스킬이 선행 스킬 순서 skill(CBD)에 있으면
                slist += j # 우선 스킬 리스트에 추가

        # 앞서 반복문을 통해 스킬을 추가한 리스트와 선행 스킬 순서가 같다면
        if slist == skill[0:len(slist)]: # slist에 저장된 요소와 CBD가 같은 경우?
            answer += 1 # 가능한 스킬트리이므로 answer 값 +1
    return answer