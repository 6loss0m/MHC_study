def solution(name): #시간 복잡도 O(n^2)
    answer = 0
    idx = 0
    min_name = [min(ord(i) - ord('A'), ord('Z') - ord(i) + 1) for i in name]
    #ord() : 문자의 유니코드 값을 돌려주는 함수
    #글자를 위로 또는 아래로 움직여 가장 횟수가 적은 방법 선택
    #A부터 이동하는게 빠른지 / Z부터 이동하는게 빠른지
    
    while True:
        answer += min_name[idx] 
        min_name[idx] = 0 
        if sum(min_name) == 0: 
            break
        
        left,right = 1,1
        while min_name[idx - left] == 0:
            left += 1
        while min_name[idx + right] == 0:
            right += 1
        #조이스틱을 왼쪽 또는 오른쪽으로 움직여야할 지를 판단
        #A일 경우에는 바꾸지 않고 넘어가도 되므로 A가 right쪽에 많은지 left쪽에 많은지 판단
        #더 적은 쪽으로 idx를 움직이게 한다.
        answer += left if left < right else right
        idx += -left if left < right else right
        
    return answer