# BOJ 2331 - 반복수열
# DFS? 로도 나중에 풀어보자

a, p = input().split() # 입력받을 D[1]와 제곱
p = int(p) # P는 숫자형으로 바꾼다. (a는 str)
d = [a] # 수열을 저장할 사전 타입

while True: # a가 d에 모두 들어갈 동안 반복
    a = d[-1]
    sum = 0
    for i in range(len(a)) :
        sum += int(a[i])**p # a의 자리수마다 p제곱하여 sum으로 더함
    if str(sum) not in d: # 사전타입에 저장된 값은 str
        d.append(str(sum)) # 딕셔너리에 a값 추가
    else :
        print(d.index(str(sum))) # a에 저장된 인덱스의 개수를 출력한다.
        break
