# BOJ 11728 - 배열 합치기
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

arr3 = arr1 + arr2   # 1차원 배열 합치기
ans = ' '.join(map(str, sorted(arr3)))
print(ans)