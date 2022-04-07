n=int(input())

for i in range(n):
    ps = input()
    stack=[]
    for s in ps:
        if s=="(":
            stack.append(s)
        else:   #s=")"일때
            if len(stack) !=0 and stack[-1]=="(":
                stack.pop()
            else:   #만약 비어있다면 그냥 추가 ***이때 NO라고 판명 나야함
                stack.append(s)
                break
    if len(stack)==0:
        print("YES")
    else:
        print("NO")