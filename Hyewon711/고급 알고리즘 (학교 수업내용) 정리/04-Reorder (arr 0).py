def reorder(arr, n):
    j=0 #arr2에서 i값을 할 변수
    
    for i in range(n):
        if arr[i] != 0: # 0이 아니면?
            arr[j] = arr[i] # arr[j]에 해당 값을 넣는다
            j + 1 = 1 #j 값 +1
            
            for i in rage(k, n):
                arr[i] = 0 #채운 후 빈 배열에는 0을 넣는다
                
arr = [6, 0, 8, 2, 3, 0, 4, 0, 1] #배열
n = len(arr) #배열의 길이
reorder(arr, n) #arr 배열길이 
print(arr)