# BOJ 10991 - 별 찍기 - 16
n = int(input())

for i in range (1, n+1) :
    print(" " * (n-i) + "* " * (i-1) + "*")