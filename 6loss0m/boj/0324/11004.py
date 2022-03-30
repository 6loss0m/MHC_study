# K번째 수
#
# 문제 :
# 입력 :
# 출력 :
n,k = map(int,input().split())
num = []
num = list(map(int,input().split()))
num.sort()
#print(num)
print(num[k-1])
