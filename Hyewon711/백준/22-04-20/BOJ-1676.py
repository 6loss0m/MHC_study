# BOJ 1676 - 팩토리얼 0의 개수
# 팩토리얼 구현방법 : for / 재귀 / math 라이브러리

n = int(input())
result = 1
answer = 0
#
# if n == 0 :
#     print("1")
#     exit()

for i in range (1, n+1, 1):
    result *= i

for j in str(result)[::-1]:
    if j == '0' :
        answer += 1
    else:
        break
print(answer)