n, k = map(int, input().split()) # 총 금액 K와 동전 종류 개수 N 입력
coins = [] # 동전 종류 금액 입력
for i in range(n):
    coins.append(int(input()))
result = 0

coins = coins[::-1]	# 내림차순으로 정렬
for i in range(n):
    if k // coins[i] > 0:	# 몫이 있는 경우 (나누어지는 경우)
        result += k // coins[i]	# 결과 값의 몫을 저장 (동전개수 세기)
        k = k % coins[i]	# 나머지를 다시 for문으로 계속 나눈다
print(result)