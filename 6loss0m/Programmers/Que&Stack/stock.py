def solution(prices):
    # 주식가격 리스트 생성
    answer = [0] * len(prices)

    # 리스트 길이 n-1 만큼 반복문
    for i in range(len(prices)-1):
        # 시작 가격부터 끝까지 반복문
        for j in range(i, len(prices)-1):
            # 만약 가격이 떨어진 경우
            if prices[i] >prices[j]:
                break # 반복문 종료
            else:
                answer[i] +=1 # 1초씩 추가
    return answer