# BOJ 10872 - 팩토리얼

n = int(input())
result = 1

if n == 0 : # 팩토리얼 0일 경우 1 출력
    print("1")
    exit()

for i in range (1, n+1, 1):
    result *= i

print(result)