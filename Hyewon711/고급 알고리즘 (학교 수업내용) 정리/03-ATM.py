n = int(input()) # 사람 수 
time = list(map(int, input().split())) # 걸리는 시간
time.sort() #시간 오름차순 정렬

ans = 0
for i in range(1, n+1): #시간 배열반복
    ans += sum(time[:i]) #오름차순으로 time[1], time[1] + time [2] ... n까지 반복하여 더한다.
    
print(ans)