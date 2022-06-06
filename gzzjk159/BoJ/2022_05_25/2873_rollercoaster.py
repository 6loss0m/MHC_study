import sys

input = sys.stdin.readline
R,C = map(int,input().split())

if R%2 == 1:
    ans = ''
    for r in range(R):
        if r%2 == 0:
            ans += 'R'*(C-1)
        elif r%2 == 1:
            ans += 'D'+'L'*(C-1)+'D'
    print(ans)
elif C%2 == 1:
    ans = ''
    for c in range(C):
        if c%2 == 0:
            ans += 'D'*(R-1)
        elif c%2 == 1:
            ans += 'R'+'U'*(R-1)+'R'
    print(ans)
else:
    min_idx,min_val = [0,0],1000
    for r in range(R):
        if r%2 == 0:
            temp = list(map(int,input().split()))
            for c in range(1,C,2):
                if temp[c] < min_val:
                    min_val,min_idx = temp[c],[r,c]
        elif r%2 == 1:
            temp = list(map(int,input().split()))
            for c in range(0,C,2):
                if temp[c] < min_val:
                    min_val,min_idx = temp[c],[r,c]

    ans = ('R'*(C-1)+'D'+'L'*(C-1)+'D')*(min_idx[0]//2)
    r,c = 2*(min_idx[0]//2),0
    nr,nc = min_idx[0],min_idx[1]
    r_bound = r+1
    while r != r_bound or c != C-1:
        if r < r_bound and [r_bound,c] != min_idx:
            r += 1
            ans += 'D'
        elif r == r_bound and [r_bound-1,c] != min_idx:
            r -= 1
            ans += 'U'
        if c != C-1:
            c += 1
            ans += 'R'

    ans += ('D'+'L'*(C-1)+'D'+'R'*(C-1))*((R-1-min_idx[0])//2)

    print(ans)