import sys

n = int(sys.stdin.readline().strip())
count = 0

while n >=5:
    count += n//5
    n//=5
print(count)

# sum=1 통과는 하지만 더 빠른 코드가 있어서 도전
# while True:
#     if n == 0:
#         break
#     else:
#         sum *= n
#         n -= 1
#
# sum = str(sum)
#
# result = 0
#
# for i in range(len(sum)-1,-1,-1):
#     if sum[i]=='0':
#         result += 1
#     else:
#         break
#
# print(int(result))