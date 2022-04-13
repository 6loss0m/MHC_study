n=int(input())
people=[]
for i in range(n):
    age, name = input().split()
    age=int(age)
    person=[age,name]
    people.append(person)
people.sort(key = lambda x:x[0])
for man in people:
    print(man[0],man[1])