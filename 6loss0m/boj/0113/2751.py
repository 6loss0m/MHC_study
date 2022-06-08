
'''
n = int(input())
num = []
for i in range(n):
    num.append(int(input()))
num.sort()
for i in num :
    print(i)
'''
n = int(input())
num = []
st = ""
for i in range(n):
    num.append(int(input()))
num.sort()
for i in num :
    st = st + str(i) + "\n"
print(st)