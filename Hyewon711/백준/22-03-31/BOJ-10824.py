# A = 10 B = 20 C = 30 D = 40 일 때, 1020 + 3040 = 4060이 되는 프로그램을 작성

a, b, c, d = input().split() # 입력받은 A, B, C, D 
a = a+b
c = c+d
print(int(a)+int(c))

# 파이썬은 입력받은 숫자도 int를 붙이지 않다면 문자열로 인식되므로 입력받은 문자열의 0번째, 1번째를 붙이고 2번째, 3번째를 붙인다.