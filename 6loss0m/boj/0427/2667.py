# 단지번호붙이기

# 지도의 크기 입력받기
n=int(input())

#집정보 입력받기
world=[]
for i in range(n):
    world.append(list(map(int,input())))

#정답을 출력할 리스트 초기화하기
answer=[]

#dfs구현
def dfs(x,y):
    if x>=0 and x<n and y>=0 and y<n:
        if world[x][y]==1:
            world[x][y]=3
            dfs(x-1,y)
            dfs(x+1,y)
            dfs(x,y-1)
            dfs(x,y+1)

            return 1
        else:
            return 0
    return 0


#덩어리 셀 변수와,이전 3의 개수 저장할 변수 초기화하기
count=0
prev=0
#개수세기
for i in range(n):
    for j in range(n):
        if dfs(i,j)==1:
            #현재 꺼 셀 변수 초기화하기
            now=0
            count+=1
            for k in range(n):
                now+=world[k].count(3)

            #지금 센 개수에서 이전 꺼 빼기
            now-=prev
            answer.append(now)
            #이전꺼는 현재꺼 더해주기
            prev+=now
            '''
            answer.append(now-prev)
            now -=prev
            prev += now
            '''
answer.sort()

print(count)
for i in answer:
    print(i)