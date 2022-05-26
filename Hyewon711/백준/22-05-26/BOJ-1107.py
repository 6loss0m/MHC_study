# BOJ 1107 - 리모컨
# 채널은 0 부터 500,000까지, 음수는 존재하지 않는다.

# 현재 채널은 100
import sys
input = sys.stdin.readline

def check(num) :
    num = list(str(num)) # 문자열로 변환, 리스트에 저장
    for i in num:
        if i in error : # 만약 error에 저장된 버튼이 포함된 경우
            return False # False 출력
    return True

n = int(input()) # 이동하려는 채널
m = int(input()) # 고장난 버튼 개수
error = list(input().strip())

result = abs (n-100) # 현재 채널 100에서 보고자하는 채널까지 +- 통해 이동해야하는 횟수
# 절댓값을 하는 이유는 n이 현재 채널 100보다 작을 수 있기 때문

for i in range (1000001) : # 예로 누르는 버튼이 9만 존재하는 경우, 999,999부터 --로 이동하므로
    # 범위는 0~500,000이 아닌 0~1,000,000 까지
    if check(i) : # check 함수를 통해 True 가 리턴되면 아래를 실행
        result = min(result, len(str(i)) + abs(i-n))
print(result)