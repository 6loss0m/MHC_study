import sys
li = []

for i in range(int(input())):
    t = sys.stdin.readline().split()
    t[1:] = map(int, t[1:])
    li.append(t)

li = sorted(li, key=lambda x : x[0]) # 이름 : 오름차순
li = sorted(li, key=lambda x : x[3], reverse = True) # 국어 : 내림차순
li = sorted(li, key=lambda x : x[2]) # 영어 : 오름차순
li = sorted(li, key=lambda x : x[1], reverse = True) # 수학 : 내림차순

for i in li:
    print(i[0])