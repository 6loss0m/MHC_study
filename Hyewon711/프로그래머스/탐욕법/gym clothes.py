# def solution(n, lost, reserve): #시간 복잡도 O(n^2)
    
#     for res in reserve: 
#         if res in lost: #만약 도난당한 학생과 여벌 체육복을 갖고있는 학생이 동일하면
#             lost.remove(res) 
#             reserve.remove(res) #리스트를 삭제 (체육복을 빌려줄 수 없기 때문)
#     answer = n - len(lost) #전체 수 - 도난당한 학생 = 이미 체육복을 갖고있는 학생 수 
            
#     for i in lost: #lost와 reserve의 교집합 리스트 제거한 상태에서 반복문
#         #reserve에 앞순서, 뒷순서에 체육복을 가지고 있는 학생이 있으면 
#         #reserve에서 삭제하고 answer에 1을 늘린다.
#         if i in reserve: 
#             answer += 1  
#             reserve.remove(i) 
                    
#         elif i - 1 in reserve: 
#             answer += 1 
#             reserve.remove(i - 1) 
                        
#         elif i + 1 in reserve: 
#             answer += 1 
#             reserve.remove(i + 1) 
                            
#     return answer

def solution(n, lost, reserve): #set :  중복이 없는 요소들 (unique elements)로만 구성된 집합 컬렉션
    reserve_n = list(set(reserve) - set(lost)) #도난, 여벌의 중복 요소 제거
    lost_n = list(set(lost) - set(reserve)) #도난, 여벌의 중복 요소 제거
    
    answer = n - len(lost_n) #이미 체육복을 가진 학생의 수
    
    for i in lost_n: #reserve_n에 앞순서, 뒷순서에 체육복을 가지고 있는 학생이 있으면
        if i - 1 in reserve_n: #앞 번호
            answer += 1 
            reserve_n.remove(i - 1) 
        elif i + 1 in reserve_n: #뒷 번호
            answer += 1 
            reserve_n.remove(i + 1) 
            
    return answer