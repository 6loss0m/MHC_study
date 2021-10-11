def solution(progresses, speeds):
    # 작업 완료까지 걸리는 시간 
    durations = []
    for progress, speed in zip(progresses, speeds):
        # 반올림 
        share = int(math.ceil((100-progress)/speed))
        durations.append(share)
        
    # 작업은 완료되었으나, 이전 기능이 완성된 상태가 아니라서 아직 배포하지 못하는 경우
    # 이때의 이전 기능의 작업 완료까지 걸리는 시간
    waiting_to_finish = durations[0]

    answer = []
    count = 1 
    for i in range(1, len(durations)):
        # 이전 기능의 작업 완료까지 걸리는 시간보다 현재 기능의 작업 시간이 더 오래 걸리는 경우, 일단 이전 기능들 배포 
        if waiting_to_finish < durations[i]:
            answer.append(count)
            count = 1 
            waiting_to_finish = durations[i]
        # waiting_to_finish >= durations[i]
        # 이전 기능의 작업 완료까지 걸리는 시간보다 현재 기능의 작업 시간이 더 적게 걸리는 경우, 이전 기능이 작업 완료될 때까지 기다렸다가 같이 배포 
        else:
            count += 1 
    
    # 마지막 count 추가 
    answer.append(count)
                   
    return answer