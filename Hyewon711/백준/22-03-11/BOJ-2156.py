# 백준 - 2156 포도주 시식
# 일렬로 놓인 포도주는 연속으로 3잔을 마실 수는 없고, 마신 포도주는 원래 위치에 다시 놓아야한다.
# 포도주를 최대한 많이 마실 수 있는 경우를 구한다.


# 연속으로 두잔 마시는 방법
# 1잔만 마시고 다다음으로 건너뛰는 방법
# 마시지않고 넘기는 방법 

n = int(input()) # 포도주 총 개수 

arr = [0,0,0] # 포도주 배열 생성시, i-3이 존재해야하므로 3자리를 비워놓는다. 
for i in range(n): # i부터 n-1까지 반복
    arr.append(int(input())) # 포도주의 양을 입력받고, arr에 저장

table = [0 for _ in range(len(arr))] # 테이블 놓여진 포도주 개수만큼 반복 ( 0부터 arr의 길이-1까지)
for i in range(3, n+3): # 3부터 n+2까지 반복
    table[i] = max(table[i-1], table[i-2] + arr[i], table[i-3] + arr[i-1]+arr[i]) # 2잔을 연속으로 마신 경우, i-1 잔을 마시지 않은경우, i-2잔을 마시지 않은 경우를 더하여 최대값을 구하고, table[i]에 대입한다.

print(max(table))