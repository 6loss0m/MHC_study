# import sys
#
# n=list(map(int,sys.stdin.readline().rstrip()))
#
# idx = 0
# num = 0
# result = ""
#
# for i in range(len(n)-1,-1,-1):
#     if idx>2 :   #순차적으로 더하기
#         result = str(num) + result
#         idx = 0
#         num = 0
#     num += n[i]*(2**idx)
#     idx += 1
#     if i == 0 :
#         result = str(num) + result
#
# print(int(result))
print(oct(int(input(), 2))[2:])