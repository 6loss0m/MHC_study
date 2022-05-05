# 나이순 정렬
# https://www.acmicpc.net/problem/10814
# 입력 : 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
# 출력 : 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
#        1<=나이<=200, 이름은 알파벳 대소문자, 길이(이름)<=100

n = int(input())
p =[]

for i in range(n):
    age,name = map(str,input().split())
    age = int(age)
    p.append((age,name))
p.sort(key = lambda x : x[0])
for i in p:
    print(i[0],i[1])
