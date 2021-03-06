# BOJ 2875 - 대회 or 인턴
# 백준대학교에서는 대회에 나갈 때 2명의 여학생과 1명의 남학생이 팀을 결성해서 나가는 것이 원칙이다.
# 대회에 참여하려는 학생들 중 K명은 반드시 인턴쉽 프로그램에 참여해야 한다. 인턴쉽에 참여하는 학생은 대회에 참여하지 못한다.

n, m, k = map(int,input().split())
ans = 0

while n >=2 and m >=1 and n+m-3>=k : # 여자가 2명이상, 남자가 1명 이상 있어야 팀을 이루고, n+m-3이 k보다 큰 경우 인턴할 학생이 존재한다.
    n = n-2
    m = m-1
    ans +=1 # 구성할 수 있는 팀의 개수 +1
print(ans)
