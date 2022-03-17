# 암호코드
# https://www.acmicpc.net/problem/2011

# 입력 : 첫째 줄에 5000자리 이하의 암호가 주어진다. 암호는 숫자로 이루어져 있다.
# 출력 : 나올 수 있는 해석의 가짓수를 구하시오.
#       정답이 매우 클 수 있으므로, 1000000으로 나눈 나머지를 출력한다.
#       암호가 잘못되어 암호를 해석할 수 없는 경우에는 0을 출력한다.

# 25114 : "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN"
# 마지막 1글자 (4=D) : BEAAD, YAAD, YKD, BEKD
#                    BEAA,YAA / YK, BEK


# 마지막 2글자 (14=n) : YAN, BEAN
#                       YA, BEA


# 첫 1글자 (2=B) : BEAAD, BEKD, BEAN

# 첫 2글자 (25=Y) : YAAD, YAN, YKD

# N : 25114
# n : [2,5,1,1,4]
n = list(map(int,input()))
#print(n)
l = len(n)
dp = [0 for _ in range(l+1)]
if (n[0] == 0) :
    print("0")
else :
    n = [0] + n
    dp[0]=dp[1]=1
    for i in range(2, l+1):
        if n[i] > 0: # 한 자리만 치환할떄
            dp[i] += dp[i-1]
        temp = n[i-1] * 10 + n[i]
        if temp >= 10 and temp <= 26 : # 두 자리를 치환할때
            dp[i] += dp[i-2]
    print(dp[l] % 1000000)
# https://jyeonnyang2.tistory.com/55
'''

n = int(input())
s_list = [0]
while n :
    s_list.append(n%10)
    n = n//10
dp = [1] * len(s_list)
if s_list[1] == 0 :
    dp[1] = 0
if len(s_list) > 2:
    if s_list[1] + (s_list[2]*10) <= 26 and s_list[1] + (s_list[2]*10) >= 11:
        dp[2] = 2
    for i in range(3,len(s_list)):
        tmp = s_list[i-1] + (s_list[i] * 10)
        #print(tmp)
        if  tmp <= 26 and tmp >= 1:
            dp[i] = dp[i-1] + dp[i-2]
        else:
            dp[i] = dp[i-1]
#print(dp)
print(dp[len(s_list)-1])
A 1
B 2
C 3
D 4
E 5
F 6
G 7
H 8
I 9
J 10
K 11
L 12
M 13
N 14
O 15
P 16
Q 17
R 18
S 19
T 20
U 21
V 22
W 23
X 24
Y 25
Z 26
'''