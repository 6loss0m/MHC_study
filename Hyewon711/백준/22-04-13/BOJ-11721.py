# BOJ 11721 - 열 개씩 끊어 출력하기
n = input()

for i in range (0, len(n), 10): # 0부터 len(n) 까지 10단위 반복
    print(n[i:i+10])