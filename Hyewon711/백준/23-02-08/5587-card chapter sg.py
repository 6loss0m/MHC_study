"""
    5587 - 카드 캡터 상근이

"""

n = int(input())
num = list(int(input()) for _ in range(n))

sang = []
geun = []

for i in range(1, 2*n+1):
    if i in num:
        sang.append(i) # 상근이가 뽑은 카드의 경우 상근이 리스트에 추가
    else:
        geun.append(i) # 아니라면 모두 근상이 카드

# 오름차순 정렬
sang.sort()
geun.sort()

now = 0 # 현재 판에 있는 수

while len(sang) > 0 and len(geun) > 0: # 둘다 카드가 존재하는 동안 while문 반복 (한 명이라도 끝나면 break
    if sang[-1] > now: # 가장 마지막에 있는 상근이 카드가 현재 판에 있는 수보다 상근이 카드가 더 큰 경우
        for i in range(len(sang)): # 반복문
            if sang[i] > now: # 작은 카드부터 확인, 판에 있는 수보다 상근이 카드가 크면
                now = sang.pop(i) # 이거 낸다!
                break # 다음 턴
    else: # 상근의 마지막 카드가 판에 있는 수보다 작다면 판 리셋 (낼 카드가 없음)
        now = 0

    if len(sang) == 0: # 만약 상근이 카드가 0장이 되면 break
        break

    if geun[-1] > now: # 가장 마지막에 있는 근상이 카드가 현재 판에 있는 수보다 크다면
        for i in range(len(geun)): # 반복문
            if geun[i] > now: # 작은 카드부터 확인, 판에 있는 수보다 근상이 카드가 크면
                now = geun.pop(i) # 이거 내기!
                break # 다음 턴
    else: # 근상의 마지막 카드가 판에 있는 수보다 작다면 판 리셋 (낼 카드가 없음)
        now = 0

print(len(geun)) # 근상이의 남은 카드 수가 상근이 점수
print(len(sang)) # 상근이의 남은 카드 수가 근상이 점수