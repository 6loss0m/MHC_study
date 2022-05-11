# BOJ 2331 - 반복수열

a, p = input().split() # 입력받을 D[1]와 제곱
p = int(p) # P는 숫자형으로 바꾼다. (a는 str)
d = [a] # 수열을 저장할 리스트

while True: # a가 d에 모두 들어갈 동안 반복
    a = d[-1] # d의 마지막 요솟값
    sum = 0
    for i in range(len(a)) :
        sum += int(a[i])**p # a의 자리수마다 p제곱하여 sum으로 더함
    if str(sum) not in d: # d에 저장된 값은 str
        d.append(str(sum)) # d에 문자 sum 추가
    else : # sum값이 d에 있는 경우 = 반복이 되는 경우 
        print(d.index(str(sum))) # a에 저장된 인덱스의 개수를 출력한다.
        break
