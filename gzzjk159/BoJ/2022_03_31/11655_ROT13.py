str = input()
rot = ""
for i in range(len(str)):
    c= ord(str[i])
    if 97<= c <=122:  #소문자일때
        if c+13<=122:
            rot += chr(c+13)
        else:
            rot += chr(97+c+13-123)
    elif 65<= c <=90:   #대문자일때
        if c+13<=90:
            rot += chr(c+13)
        else:
            rot += chr(65+c+13-91)
    else:
        rot += str[i]
print(rot)
# 초기 답안 무식하게 품
# str = input()
# rot = [0]*len(str)
# for i in range(len(str)):
#     c= ord(str[i])
#     if str[i]==" ":
#         rot[i]=" "
#     elif 97<= c <=122:  #소문자일때
#         if c+13<=122:
#             rot[i] = chr(c+13)
#         else:
#             rot[i] = chr(97+c+13-123)
#     elif 65<= c <=90:   #대문자일때
#         if c+13<=90:
#             rot[i] = chr(c+13)
#         else:
#             rot[i] = chr(65+c+13-91)
#     else:
#         rot[i]=str[i]
# rot = "".join(rot)
# print(rot)