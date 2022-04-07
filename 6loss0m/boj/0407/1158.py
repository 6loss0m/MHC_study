# 요세푸스 문제
n, k = map(int, input().split())
# n = 1 인경우 예외처리
if n == 1:
    print('<'+str(n)+'>')
else:
    p = [int for int in range(1,n+1)]
    ans = []
    cur = -1
    while p :
        cur = (cur+k)%len(p)
        ans.append(p[cur])
        p.pop(cur)
        cur -= 1
        #print(ans)
    # 제 입장에서 간단하게
    print('<',end='')
    for i in range(len(ans)-1):
        print(ans[i],end=", ")
    print(str(ans[i+1])+">")
#print(ans)