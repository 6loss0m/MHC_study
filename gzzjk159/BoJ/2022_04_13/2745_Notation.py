import sys

n = sys.stdin.readline().strip().split()
nota_num = int(n[1])    #몇 진수 인지 받는 숫자
nota_list = list(n[0])  #문자를 리스트로 하나씩 나열
result = 0   #10진수 변환 최종값

idx = 0    #리스트 인덱스

for i in range(len(nota_list)-1,-1,-1):
    a = ord(nota_list[idx])
    if nota_num<=10:
        result += (a-48)*(nota_num**i)
    else:
        if 65 <= a <= 90: #대문자일때
            result += (a-55)*(nota_num**i)
        elif 48 <= a <= 57:  #숫자일때
            result += (a-48)*(nota_num**i)
    idx += 1
print(result)