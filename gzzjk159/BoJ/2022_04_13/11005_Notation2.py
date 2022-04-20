# import sys
#
# n = list(map(int,sys.stdin.readline().strip().split()))
# nota_list = []  #빈리스트 만들기
# num = n[0]  #받은 숫자
# nota_num = n[1] #몇 진수인지 하는 변수
# idx = 0
# result = ""
# while num>0:
#     mod = num%nota_num
#     num = num//nota_num
#     if mod<=10: #숫자일때
#         result = chr(mod+48) + result
#     else:   #문자일때
#         result = chr(mod+55) + result
# print(result)

system = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"  # 10진법이면 9 까지, 36진법이면 Z까지 표현된다
N, B = map(int, input().split())
answer = ''

while N != 0:
    answer += str(system[N % B])  # 위치로 진법 변환
    N //= B

print(answer[::-1])