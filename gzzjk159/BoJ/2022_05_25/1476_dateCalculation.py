e,s,m = map(int, input().split())
answer=1
ed,sd,md = 1,1,1

while True:
    if ed==e and sd ==s and md==m:
        break
    ed += 1
    sd += 1
    md += 1
    answer +=1
    if ed>=16:
        ed = 1
    if sd >=29:
        sd = 1
    if md >= 20:
        md = 1
print(answer)