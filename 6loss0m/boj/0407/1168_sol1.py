import sys

seg = [0] * 300000
#print(t,seg)

def init(s, e, node):
    if s == e:
        seg[node] = 1
        return seg[node]
    mid = (s+e)/2
    seg[node] = init(s,mid,node*2) + init(mid+1,e,node*2+1)
    return seg[node]
def update(s,e,node,index):
    seg[node] -= 1
    if s == e:
        return s
    mid = (s+e)/2
    if index > seg[node*2]:
        return update(mid+1,e,node*2+1,index-seg[node]*2)
    else:
        return update(s,mid,node*2,index)

n,k = sys.stdin.readline().split()
n = int(n)
k = int(k)
init(1,1,n)
index = k-1
print("<",end='')
for i in range(1,n+1):
    get_idx = update(1,1,n,index+1)

    if i != n:
        print(get_idx,end=", ")
    else:
        print(get_idx)

    if seg[1] == 0:
        break
    index = index + (k-1)
    index = index%seg[1]

print(">")