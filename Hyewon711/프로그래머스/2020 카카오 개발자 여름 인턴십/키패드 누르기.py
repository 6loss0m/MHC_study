def solution(numbers, hand):
    keypad=[[1,2,3],[4,5,6],[7,8,9],["*",0,"#"]] # 키패드 
    result=[] # L, R을 저장할 결과값
    left,right=(3,0),(3,2) # 시작 위치 (L = "*", R = "#")
    
    def find_index(value): # 값을 통해 좌표를 찾는 함수
        for i in range(4): # i = 행
            for j in range(3): # j = 열
                if keypad[i][j] == value: # [i][j]에 위치한 keypad 값과 value가 같다면 반환
                    return (i,j) 

    for number in numbers: # numbers 배열의 크기는 1 이상 1,000 이하
        if number in (1,4,7): # 만약 왼손 엄지로 누르는 키패드의 경우 
            result.append("L") # 결과값에 L 추가
            left = find_index(number) # left의 현재 위치 변경
            
        elif number in (3,6,9): # 만약 오른손 엄지로 누르는 키패드의 경우 
            result.append("R") # 결과값에 R 추가
            right=find_index(number) # Right의 현재 위치 변경
            
        else: # 둘다 아닌 경우 ( 2, 5, 8, 0을 누르는 경우 )
            x, y = find_index(number)
            left_x, left_y = left # 왼손의 현재 좌표를 각각 따로 저장한다.
            right_x, right_y = right # 오른손의 현재 좌표를 각각 따로 저장한다.
            
            # 좌표 거리 계산 (abs : 절대값 )
            left_dis = abs(left_x-x)+abs(left_y-y)
            right_dis = abs(right_x-x)+abs(right_y-y)
            
            # 왼손이 더 가까운 경우 
            if left_dis < right_dis:
                result.append("L")
                left=find_index(number)
                
            # 오른손이 더 가까운 경우 
            elif left_dis > right_dis:
                result.append("R")
                right=find_index(number)
                
            # 두 거리가 같은 경우, 왼손잡이라면 
            else:
                if hand == "left":
                    result.append("L")
                    left = find_index(number)
                    
            # 두 거리가 같은 경우, 오른손 잡이라면 
                else:
                    result.append("R")
                    right = find_index(number)
    
    # 저장된 결과값을 join 한다.
    return ("".join(result))