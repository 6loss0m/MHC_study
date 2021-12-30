def solution(triangle):
    for j in range(1, len(triangle)):
        for i in range(j+1):
            # 삼각형 각층의 첫번째인 경우
            if i==0:
                triangle[j][0] += triangle[j-1][0]
            # 삼각형 각층의 마지막인 경우
            elif i==j:
                triangle[j][-1] += triangle [j-1][-1]
            # 내부 부분인 경우
            else:
                triangle[j][i] += max(triangle[j-1][i-1],triangle[j-1][i])
    answer = max(triangle[-1])
    return answer

# 참고 : https://codedrive.tistory.com/49