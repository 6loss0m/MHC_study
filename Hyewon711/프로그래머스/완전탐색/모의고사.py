def solution(answers):
    answer = []
    student1 = [1, 2, 3, 4, 5] #수포자1
    student2 = [2, 1, 2, 3, 2, 4, 2, 5] #수포자2
    student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] #수포자3
    result = [0] * 3 #정답의 수 저장하기 

    for index, ans in enumerate(answers): #enumerate : 리스트의 원소에 순서값을 부여해주는 함수
        #현재 문제의 정답과 수포자1이 찍은 정답이 일치하는 경우 
        if ans == student1[index % len(student1)]: 
            #result[0]의 첫 인덱스에 +1 
            result[0] += 1
        if ans == student2[index % len(student2)]:
            result[1] += 1
        if ans == student3[index % len(student3)]:
            result[2] += 1

    # 가장 많은 문제 맞힌 사람 찾기(동점자 포함)
    for i in range(3):
        if result[i] == max(result):
            #정답 개수가 같은 경우 append 
            answer.append(i+1)
    #저장된 수포자 목록이 정답이 된다.
    return answer