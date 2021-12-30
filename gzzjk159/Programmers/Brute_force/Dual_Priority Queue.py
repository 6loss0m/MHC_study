def solution(operations):
    answer = []
    for i in operations:
        c,num = i.split(" ")
        if c =="I":
            answer.append(int(num))
        else:
            if len(answer)>0:
                if num=="1":
                    answer.pop()
                else:
                    answer.pop(0)
            else:
                pass
        answer.sort()
    if len(answer)==0:
        return [0,0]
    else:
        return [max(answer), min(answer)]
