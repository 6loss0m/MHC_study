#빨리 끝나는 프로세스를 먼저 실행하는 것이 평균을 가장 줄이는 방법
# heapq : sort와 달리 전체를 정렬하는 것이 아닌 가장 작은 값을 가지는 원소를 리스트의 맨 앞에 정렬하는 것 
# jobs = [작업이 요청되는 시점, 작업의 소요시간] 
# heapq를 이용하여 우선순위큐 정렬한 후 작업이 실행되는 시간동안 들어온 요청들에 대해 
# 현재 작업이 끝나는 시간까지 걸린 시간을 더한다.
    
import heapq

def solution(jobs):  # 작업 순
    answer = 0
    heap = []
    length = len(jobs) #작업의 수 
    end_time = 0 
    idx = 0 
    jobs.sort() #작업이 요청되는 시점 -> 작업 소요시간 기준으로 오름차순으로 정렬

    while idx < length: #작업의 수 길이까지 반복
        if heap: # heap이 존재하는 경우
            request, time = heapq.heappop(heap)	# 요청 시점, 작업 소요 시간 
            end_time += request  # 현재 시간(최근 작업의 끝)
            answer += end_time - time	# 어떤 작업의 대기 ~ 끝난 시간
        else:	# 들어온 작업이 없을 때
            request, time = jobs.pop(0)	# 작업이 요청되는 시점, 작업의 소요시간
            end_time = request + time 
            answer+=time
        
        # 원소가 있고 요청시점 <= 현재시간
        while jobs and jobs[0][0] <= end_time:	
            heapq.heappush(heap, jobs.pop(0)[::-1])	# [작업의 소요시간, 작업이 요청되는 시점]
        
        idx += 1	# 작업 처리한 갯수
        
    return answer // length