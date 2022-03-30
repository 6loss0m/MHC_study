T = int(input())
user = []

for _ in range(T):
    a,b = input().split()
    a = int(a)
    user.append([a,b])
    
user.sort(key=lambda x : x[0])

for i in range(T):
    print(user[i][0],user[i][1])