n, k = map(int, input().split()) #n, k를 한줄에 입력받음
arr = map(int, input().split()) # arr 를 입력받음
arr = sorted(arr) # arr sort (오름차순)
print(arr[k-1]) # 출력 (리스트는 0부터이므로 -1)