# 17681 - 비밀지도
# 두 지도를 겹쳤을 때 벽(#)은 or 공백( )은 and 연산

def solution(n, arr1, arr2):
    # 먼저 arr 리스트에 저장된 요소들을 2진수로 변환하기
    # arr1, arr2는 길이가 같음
    answer = [''] * n # answer의 길이는 n (지도의 한 변의 길이)

    for i in range(len(arr1)): # arr 길이만큼
        a1 = bin(arr1[i])[2:].zfill(n) # 2진수로 변환, zfill은 앞에서부터 자리수만큼 빈곳에 0 채우기
        a2 = bin(arr2[i])[2:].zfill(n) # 2진수로 변환, zfill은 앞에서부터 자리수만큼 빈곳에 0 채우기

        for j in range(n): # 한변의 길이
            if a1[j] == '0' and a2[j] == '0': # 만약 0이 있다면 공백 처리
                answer[i] += ' '
            else:
                answer[i] += '#' # 0이 없다면 벽 처리
    return answer