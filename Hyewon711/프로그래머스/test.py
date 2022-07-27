def soojebi(num):
    if num < 2 :
        print(num, end='')
    else:
        soojebi(num//2)
        print(num%2, end='')

soojebi(20)