# 출력순서 : 소문자, 대문자, 숫자, 공백의 개수

try :
    while(True) :
        n = input()
        low, upp, digit, space = 0, 0, 0, 0

        for i in n :
            if i.islower() : # 소문자인 경우
                low += 1
            elif i.isupper() : # 대문자인 경우
                upp += 1
            elif i.isdigit() : # 숫자인경우
                digit += 1
            elif i == ' ' : # 공백인 경우
                space += 1

        print(low, upp, digit, space)

except :
    exit()