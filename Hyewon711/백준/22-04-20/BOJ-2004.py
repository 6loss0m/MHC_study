# BOJ 2004 - 조합 0의 개수
# 조합 : n개의 원소를 갖는 집합에서 r개의 원소를 선택하는 경우의 수 찾기
# 문제는 끝자리 0의 개수를 출력하는 프로그램을 작성
# 예 ) 25 12 의 경우 2가 나온다.
# nCr = n! / r! * (n-r)! 이용
# 조합은 math 라이브러리 combination 이 있음

N, M = map(int, input().split())

# 끝자리가 0이라는 것은 10의 배수
# 10은 2와 5로 구성되어 있음
# 2와 5 짝이 맞아야 10이 되므로 2의 개수와 5의 개수중 더 작은게 10의 개수이다.

def count_number(n, k):
    count = 0
    while n:
        n //= k
        count += n
    return count

five_count = count_number(N, 5) - count_number(M, 5) - count_number(N - M, 5)
two_count = count_number(N, 2) - count_number(M, 2) - count_number(N - M, 2)

answer = min(five_count, two_count)
print(answer)


# 시간초과 코드
# n, m = map(int, input().split())
# answer = 0
#
# def factorial (n):
#     result = 1
#     for i in range (1, n+1, 1):
#         result *= i
#     return result
#
# tmp1 = factorial(n)
# tmp2 = factorial(m)
# tmp3 = factorial(n-m)
#
# com = tmp1 / (tmp2 * tmp3)
#
# for j in str(int(com))[::-1]:
#     if j == '0' :
#         answer += 1
#     else:
#         break
# print(answer)


