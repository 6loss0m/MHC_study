# 선택한 이유
# 1. 실행 시간이 가장 짧음
# 2. 가독성이 좋고 코드가 간결함
def solution(progresses, speeds):
    Q=[]
    # zip 함수 : iterator , 두 인자를 하나의 쌍으로 반환
    for p, s in zip(progresses, speeds):
        # 리스트가 비어있거나, 이전 작업보다 늦게 끝날 때
        if len(Q)==0 or Q[-1][0]<-((p-100)//s):
            Q.append([-((p-100)//s),1]) # 새로운 배포 추가
        # 이전 작업과 같거나 일찍 끝나는 경우
        else:
            Q[-1][1]+=1 # 배포 개수 추가
    # [남은량, 속도] 에서 [1] 번째 인자인 속도 반환
    return [q[1] for q in Q]