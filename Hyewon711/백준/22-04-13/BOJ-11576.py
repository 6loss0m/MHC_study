# BOJ 11576 - Base Conversion
# A 진법으로 나타낸 수를 B진법으로 변환
# A진법 수 -> 10진수 -> B진법 수로 변환한다.

a,b = map(int,input().split())
m = int(input())
AtoDec = list(map(int, input().split()))
AtoDec.reverse() # 10진수를 구할 때 0부터 제곱하기 편하도록 reverse 해준다.
result = []
ten = 0

for i in range(m):
    ten += AtoDec[i]*(a**i) # 먼저 a진수를 10진수로 변환한다. (자리마다 제곱값 0~m까지 곱해준 후 모두 더하면 10진수 값이 된다.)
    # ex) 2진수 111 = 2^2+2^1+2^0 = 10진수 7과 같다.

# b진수 구하기
# b로 나누면서 나머지는 result에 저장하는 과정을 반복한다.


while ten//b:
    result.append(ten%b)
    ten = ten//b
result.append(ten)

result.reverse() # result에 저장된 나머지 값을 거꾸로 출력하면 b진수로 바꾼 값이 된다.
print(' '.join(map(str, result))) # 수 사이는 공백을 준다.