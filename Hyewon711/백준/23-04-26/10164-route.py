"""
    10164 - 격자상의 경로
"""

N, M, C = map(int, input().split())
info = [[1] * M for _ in range(N)]

circle_y = (C-1) // M # 행 부분
circle_x = (C-1) % M # 열 부분

def circle(n, m, c): # ○ 표시 찾기
    if c == 0:
        for i in range(1, n):
            for j in range(1, m):
                info[i][j] = info[i-1][j] + info[i][j - 1]
        return info[n-1][m-1]
    else:

        if c == m or c == 1 + m*(c-1):
            return 1

        for i in range(1, circle_y+1):
            for j in range(1, circle_x+1):
                info[i][j] = info[i-1][j] + info[i][j-1]

        for i in range(circle_y+1, n):
            for j in range(circle_x+1, m):
                info[i][j] = info[i-1][j] + info[i][j-1]

        return info[circle_y][circle_x] * info[n-1][m-1]

print(circle(N, M, C))



# import java.util.Scanner
#
# fun main() {
#     val sc = Scanner(System.`in`)
#     val N = sc.nextInt()
#     val M = sc.nextInt()
#     var K = sc.nextInt()
#     var result = 0
#     if (K == 0) {
#         K = N * M
#     }
#     val list = IntArray(N * M)
#     list[0] = 1
#     result = find(1, list, 1, N, M, K, result)
#     println(result)
# }
#
# fun find(num: Int, list: IntArray, depth: Int, N: Int, M: Int, K: Int, result: Int) {
#     var currentResult = result // result 변수 대신 currentResult 변수를 사용
#     if (num == M * N) { // 격자 끝까지 도달한 경우
#         for (i in 0 until depth) {
#             if (list[i] == K) {
#                 currentResult++
#                 break // 이미 K를 찾았으므로 반복문 break
#             }
#         }
#     } else {
#         if (num + 1 <= M * N && num % M != 0) {
#             list[depth] = num + 1
#             find(num + 1, list, depth + 1, N, M, K, currentResult) // 재귀
#         }
#         if (num + M <= M * N) {
#             list[depth] = num + M
#             find(num + M, list, depth + 1, N, M, K, currentResult) // 재귀
#         }
#     }
#     return currentResult
# }


