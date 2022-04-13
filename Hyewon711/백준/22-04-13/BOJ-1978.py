# BOJ 1978 - 소수 찾기

n = int(input()) # 입력받는 수의 개수
m = list(map(int, input().split(' '))) # 입력받는 수의 목록
ans = 0 

for i in m : # m이 1, 3, 5의 경우라면 i=1, i=3, i=5의 경우를 반복
    cnt = 0 # cnt 초기화
    for j in range (2, i+1) : # 2부터 현재 i의 값까지 반복 소수는 1을 포함하지 않으므로 2~n까지 반복
        if (i%j == 0) : # 만약 i와 j가 나누어 떨어지면 ( 나머지 0 )
            cnt += 1 # 카운트 += 1
    if(cnt == 1):
        ans += 1 # cnt가 1일 경우 소수이므로 ans += 1
print(ans)
            