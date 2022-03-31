cases = int(input()) # 테스트 케이스 개수 

for i in range(cases): 
    a,b = map(int, input().split())
    ans = a + b
    print("Case #%s: %s"%(i+1, ans )) # "Case #x: " 출력한 후, A+B를 출력한다.