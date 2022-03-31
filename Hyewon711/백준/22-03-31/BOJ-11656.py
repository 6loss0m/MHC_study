# 접미사 배열 : 문자열 S의 모든 접미사를 사전순으로 정렬해놓은 배열
# 문제는 알파벳 소문자로만 이루어져있기에 97~122번 할당
# 문자열을 아스키 코드값으로 비교하고, sort 하여 정렬하는 것이 좋을 것 같다 

n = input()
answer = []

for i in range(len(n)) :
    answer.append(n[i:]) # 입력받은 문자열 리스트 추가 

answer = sorted(answer)

for i in range(len(n)) :
    print(answer[i]) 