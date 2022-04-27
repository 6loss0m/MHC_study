# 열 개씩 끊어 출력하기
st = input()
l = len(st)

if l < 10:
    print(st)
else:
    for i in range(0,l,10):
        print(st[i:i+10])