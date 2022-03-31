# 국영수
# https://www.acmicpc.net/problem/10825
# 문제 : 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다.
#       이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

# 입력 : 첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다.
#       둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다.
#       점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
#       이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.

# 출력 : 문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.

n = int(input())
people = []
for i in range(n):
    name,kor,eng,math = map(str,input().split())
    kor = int(kor)
    eng = int(eng)
    math = int(math)
    people.append((name,kor,eng,math))

people.sort(key = lambda x : (-x[1],x[2],-x[3],x[0]))

for i in people:
    print(i[0])