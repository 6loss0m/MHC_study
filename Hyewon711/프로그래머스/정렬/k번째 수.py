array = [1, 5, 2, 6, 3, 7, 4] 
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]] 
#return으로 5, 6, 3의 결과가 나와야한다. 

def solution(array, commands):
    answer = []

    for i in commands:
        temp = array[i[0] - 1 : i[1]] #반복문 - 2차원 배열을 1차원 배열로 저장

        temp.sort() #오름차순으로 정렬한다 (리스트 정렬 sort)
        sorted(temp)

        answer.append(temp[i[2] - 1]) #정렬된 값의 k번째 수를 가져온다. (리스트 요소 추가 append)
    return answer