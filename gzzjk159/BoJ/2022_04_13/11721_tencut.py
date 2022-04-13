import sys

s = sys.stdin.readline().strip()

for i in range(len(s)):
    print(s[i], end="")
    if (i%10)==9:
        print("")
"""
0   1   2   3   4   5   6   7   8   9
10  11  12  13  14  15  16  17  18  19
i가 9일 때 출력하고 한칸 띄면 됨
-> (i%10)==9일때 만족
"""