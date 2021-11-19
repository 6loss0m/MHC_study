a = int(input())
if a%4 == 0:
    if a%100 != 0:
        print(1)
    elif a%400 == 0:
        print(1)
    else:
        print(0)
else:
    print(0)