# BOJ 11576 - Base Conversion
# A 진법으로 나타낸 수를 B진법으로 변환
# A진법 수 -> 10진수 -> B진법 수로 변환한다.

a,b = map(int,input().split())

m = int(input())
#m번 반복하라고 준거겠지?

arr = list(map(int,input().split()))
#10진수부터 구할까
arr.reverse()

ten = 0
for i in range(m):
    ten += arr[i]*(a**i)

# b진수 구하기
#나누어 떨어질때까지
result = []
while ten//b:
    result.append(ten%b)
    ten = ten//b
result.append(ten)

result.reverse()
print(' '.join(map(str,result)))

# 출처 : https://velog.io/@mauserne/%EB%B0%B1%EC%A4%80-11576-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4-python
