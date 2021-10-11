def solution(priorities, location):
    #(인덱스, 중요도)를 튜플로 만들어서 queue에 넣는다
    queue=[(i,p) for i,p in enumerate(priorities)]
    answer=0 # 출력된 순서 체크용

    while True:
        front=queue.pop(0)
        #맨 앞에 있는 문서보다 더 중요한게 하나라도 있다면 맨 앞의 문서를 뒤로 보낸다.

        if any(front[1]<q[1] for q in queue):  #front[1]:맨앞의 중요도  q[1]: 큐 안의 중요도
            queue.append(front)
        else: #출력한 문서가 문제에서 요구하는 문서인지 체크
            answer +=1
            if front[0] == location:
                return answer