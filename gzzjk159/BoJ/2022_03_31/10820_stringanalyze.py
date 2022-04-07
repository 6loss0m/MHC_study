while True:
    try:
        str = input()
        lower, upper, num, blank = 0,0,0,0
        for i in str:
            if i==" ":
                blank += 1
            elif 65 <= ord(i) <=90:
                upper += 1
            elif 97 <= ord(i) <=122:
                lower += 1
            else:
                num += 1
        print(lower,upper,num,blank)
    except EOFError:
        break