n = int(input())
dict = {}
for i in range(n):
    card=int(input())
    if card in dict:
        dict[card] += 1
    else:
        dict[card] = 1
card_dict = sorted(dict.items(), key= lambda x:(-x[1],x[0]))
print(card_dict[0][0])