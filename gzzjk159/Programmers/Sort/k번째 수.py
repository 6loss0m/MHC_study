def solution(array, commands):
    answer = []
    for command in commands:
        new_array = array[command[0]-1:command[1]]
        new_array.sort()
        answer.append(new_array[command[2]-1])
            
    return answer
  
  #for문 하나이므로 시간복잡도 n
