# 카드
# https://www.acmicpc.net/problem/11652
# 문제 : 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오.
#       만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
# 입력 : 첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
#       둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
# 출력 : 첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.
import sys
n = int(sys.stdin.readline())
dic = {}

for case in range(n):
    tmp = int(sys.stdin.readline())
    if tmp in dic:
        dic[tmp] += 1
    else:
        dic[tmp] = 1
#print(dic)
dic = sorted(dic.items(), key=lambda x: (-x[1], x[0]))
print(dic[0][0])
# https://johnyejin.tistory.com/101