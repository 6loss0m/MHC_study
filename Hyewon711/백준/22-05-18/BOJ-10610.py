# BOJ 10610 - 30
# 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.

n = list(input())
n = sorted(n, reverse=True)
ans = 0

# 끝자리에 0이 와야 30의 배수가 될 수 있다. ( n 문자열에 0이 없는 경우 -1 출력)
if '0' not in n :
    print(-1)

else:
    for i in n :
        ans += int(i) # n을 이루는 모든 수의 합이 3의 배수인경우와 0이 포함된 경우 = 30의 배수
    if ans % 3 == 0 : # 3의 배수인 경우
        print(''.join(n)) #가장 큰 값 출력을 위해 reverse (역순)
    else :
        print(-1)
