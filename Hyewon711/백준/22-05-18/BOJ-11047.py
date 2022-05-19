# BOJ 11047 - 동전 0
# 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
# 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

n, k = map(int, input().split())
coins = []
for i in range(n):
    coins.append(int(input()))
result = 0

coins = coins[::-1]	# 내림차순으로 정렬
for i in range(n):
    if k // coins[i] > 0:	# 가치의 합 K를 동전단위(원)로 나눌 수 있다면
        result += k // coins[i]	# 나누어 발생한 몫 즉, 동전 갯수
        k = k % coins[i]	# 나머지를 다시 for문으로 계속 나눈다
print(result) # 동전개수의 최소값을 구하는 것이므로, 무조건 큰 단위의 동전을 많이 쓰는 것이 좋다.