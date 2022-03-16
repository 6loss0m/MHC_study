n=int(input())
s=[0]*(n+3) #계단 리스트 만들기
dp=[0]*(n+3) #dp리스트 만들기
for j in range(1,n+1):
    s[j]=int(input())    #계단 수 갱신
dp[1]=s[1]
dp[2]=s[1]+s[2]
dp[3]=max(s[1]+s[3],s[2]+s[3]) #dp[3]는 둘중 하나 골라야해서 넣기
for i in range(4,n+1):
    dp[i]=max(dp[i-3]+s[i-1]+s[i],dp[i-2]+s[i]) #바로 앞에꺼 밟고 오르기와 밟지 않고 오르기 비교
print(dp[n])