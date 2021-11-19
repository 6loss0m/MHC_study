def solution(N, number):
	#dp[i]는 N을 i번만 사용해서 나타낼 수 있는 수들의 집합이다.
    #기본적으로 연산을 하지않을 때 당연히 생각할 수 있는 수들은 {N, NN, NNN, NNNN,... 같은 것들이 있다.
    dp  =[set([N*int('1'*i)]) for i in range(1, 9)] 
    
    """
    이제 이걸 바탕으로
    k번 사용해서 나타낼 수 있는 수들의 집합은 아래와 같이 표현 할 수 있다.
    {k번 집합} = {k-i번 집합} (사칙연산) {i번 집합}
    즉 N을 k번 사용해서 나타낼 수 있는 집합은 
    N을 k-i번 사용해 나타낼 수 있는 수들과 i 번 사용해서 나타낼 수 있는 수의 사칙연산에 의해 나타낼 수 있다.
    """
    for i in range(8): #N을 사용한 횟수 
        for j in range(i):
            for num1 in dp[j]:  #i 번 사용해서 나타낼 수 있는 수 
                for num2 in dp[i-j-1]: # N-i번 사용해서 나타낼 수 있는 수
                	# 사칙연산
                    dp[i].add(num1 + num2)
                    dp[i].add(num1 - num2)
                    dp[i].add(num1 * num2)
                    if num2 != 0:
                        dp[i].add(num1//num2)
                        
        #위 과정을 끝내면 N을 i번 사용해서 나타낼 수있는 수가 dp[i]에 저장된다.
        # 만약 그 집합안에 'number'가 있으면 
        if number in dp[i]:
            return i+1 # 정답 출력
    return -1
