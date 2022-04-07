str = input()
lst = [0]*len(str)
for i in range(len(str)):
    lst[i] = str[i:]
lst.sort()
for i in range(len(str)):
    print(lst[i])