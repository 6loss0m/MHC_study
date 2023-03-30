"""
    9440 - 숫자 더하기
    주의할 점 :
    첫 번째 숫자는 사용될 숫자의 개수
    두 번째부터 사용될 N개의 숫자가 주어지는데, 0이 아닌 수가 최소 2개 이상 존재한다고 한다.
    즉, 0이 존재할 수도 있는데 가장 작은 수를 더할 때에는 입력받은 수를 모두 정렬한 후,
    큰 수부터 1의 자리로 구성되는 게 옳지만 0은 맨 앞에 올 수 없으므로
    이 경우를 생각해주어야 한다.

"""

while True : # 0이 입력될 때까지
    n = input()
    if n == '0': break # 0이 입력되면 break
    number = sorted(n.split()[1:]) # 입력받은 수(맨 처음 수 제외)를 split하여 오름차 순으로 정렬을 한다.
    num1, num2 = str(), str() # 0이 아닌 가장 작은 수를 저장할 변수 num1, num2
    for i in range(len(number)): # 입력받은 수의 길이까지
        if number[i] != '0': # 0이 아닌 경우라면
            num1, num2 = number[i], number[i+1] # 가장 작은 두 수를 저장
            number = number[:i] + number[i+2:] # number[i], number[i+1]을 제외한 수를 number로 붙이기
            break # for문 탈출~
    for i in range(0, len(number), 2): # 2단계씩 건너뛰며 반복문
        num1 += number[i] # 아까 가장 작은 수를 구한 변수에 다음으로 작은 숫자 붙이는 중..
        if i < len(number)-1: # number길이-1 인 경우 if문이 계속 실행됨
            num2 += number[i+1] # 아까 구한 두 번째로 가장 작은 수 num2에 다음으로 작은 숫자 붙이는 중..

    print(int(num1) + int(num2)) # 위 반복문을 모두 거친 후 다시 int형으로 변환하여 두 수를 더해주면 나올 수 있는 가장 작은 수