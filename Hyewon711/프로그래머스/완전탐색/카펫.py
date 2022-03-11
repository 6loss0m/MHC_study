def solution(brown, yellow):
    #카펫의 넓이 = brown + yellow = width x height
    # 4*3 의 경우 10 + 2 = 4 x 3
    #외부 사각형 갯수(brown) = 2w + 2h + 4
    #내부 사각형 갯수(yellow) = (x-2) * (y-2)
    
    total = brown + yellow #카펫의 넓이
    # 카펫의 가로길이가 세로길이보다 길거나 같다.
    for weight in range(total, 2, -1): #1이 아닌 -1로 반복문 실행
        
        if total % weight == 0: # 카펫 넓이에서 가로 길이 탐색
            height = total // weight # 카펫넓이 / 가로길이를 통해 세로길이 탐색
            # 구해진 카펫의 길이에서 테두리길이(2)만큼 빼주고 면적을 구한뒤 yellow의 면적과 같다면 
            if yellow == (weight-2) * (height-2):
                #해당 값이 카펫의 격자
                return [weight, height]