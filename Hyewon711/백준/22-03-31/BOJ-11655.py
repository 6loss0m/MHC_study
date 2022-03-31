# ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
# 쉽게 생각하면, 아스키코드 값에 13을 더하고 문자열로 변환하면 된다. 
# 대문자, 소문자인 경우 두가지로 나누어 구현하는 방법이 좋을 것 같다.


n = input()
str = 'abcdefghijklmnopqrstuvwxyz'
answer = []

for i in n :
    if i.islower() : # 소문자인 경우 : 아스키 코드 97~122번 할당
        index = (str.index(i) + 13) % 26
        answer.append(str[index])

    elif i.isupper() : # 대문자인 경우 : 아스키 코드 65~90번 할당
        i = i.lower()
        index = (str.index(i) + 13) % 26
        answer.append(str[index].upper())

    else :# 공백인 경우 그대로 추가
        answer.append(i)

for i in answer :
    print(i, end='') 