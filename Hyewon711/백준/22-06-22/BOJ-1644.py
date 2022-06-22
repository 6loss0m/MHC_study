# BOJ 1644 - 소수의 연속합
# 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다.
# 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다.
#  (1 ≤ N ≤ 4,000,000) 이므로 에라스토테네스의 체로 소수를 구하고 리스트에 저장
# 연속의 합이므로 전에 푼 2003, 1806와 같이 투 포인터를 이용해서 경우의 수를 세서 출력하는 풀이

# 에라토스테네스의 체 > https://my-coding-notes.tistory.com/11 (for문이 아닌 슬라이싱 이용하여 배수 제거)

import sys

input = sys.stdin.readline
n = int(input())
arr = [] # 에라스토테네스의 체로 소수 저장할 리스트
cnt = 0
left, right = 0, 0
sum = 0

# 에라토스테네스의 체
a = [False, False] + [True]*(n-1)
for i in range(2, int(n**0.5)+1):
    if a[i]:
        a[i*2::i] = [False]*((n-i)//i)

# 소수 배열 생성
for i in range( n+1 ):
    if a[i] == True: # 소수가 맞다면 ?
        arr.append(i) # arr에 추가

# 현재 구간의 합이 n보다 작다면 현재 구간의 끝점을 늘려야 한다. (right+1)
# 반대로 현재 구간의 합이 n보다 크다면 시작점을 늘려야 한다. (left+1)

# 투 포인터로 정답 구하기
while (left < n) :
    if sum == n: # sum의 값이 구하고자 하는 수와 같다면
        cnt += 1 # 경우의 수 +1

    if sum > n: # 현재 구간의 합이 n보다 큰 경우
        sum -= arr[left] # a[left]를 sum에서 빼주어 현재 sum의 값을 수정한다.
        left += 1  # 왼쪽 포인터 한칸 이동

    elif right == len(arr): # 만약 right가 끝까지 도달한 경우
        break # break

    else: # 현재 구간의 합이 n보다 작은 경우
        sum += arr[right] # 현재 위치한 arr[right] 값을 sum에 추가
        right += 1  # 오른쪽 포인터 한칸 이동

print(cnt)