# 공유기 설치

n, c = map(int, input().split())

# 집 좌표 입력
array = []
for i in range(n):
    array.append(int(input()))

array.sort()

# 이진트리
def binary_search(array, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = array[0] # 공유기 설치
        count = 1

        for i in range(1, len(array)):
            if array[i] >= current + mid:
                count += 1
                current = array[i]

        if count >= c:
            global answer
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1
end = array[-1] - array[0] # 최
# 대길이
answer = 0

binary_search(array, start, end)
print(answer)

# https://hongcoding.tistory.com/3