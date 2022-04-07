t = int(input())
ott=[1,2,4]
for i in range(3,10):
    ott.append(ott[i-3]+ott[i-2]+ott[i-1])
for j in range(t):
    n=int(input())
    print(ott[n-1])