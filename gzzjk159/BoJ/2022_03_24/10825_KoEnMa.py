n = int(input())
test = [[0 for _ in range(4)] for _ in range(n)]
for i in range(n):
    name,kor,eng,math = input().split()
    test[i][0] = name
    test[i][1] = int(kor)
    test[i][2] = int(eng)
    test[i][3] = int(math)
test.sort(key = lambda x:(-x[1],x[2],-x[3],x[0]))
for i in range(n):
    print(test[i][0])