#!/usr/bin/env python
# coding: utf-8

import pandas as pd

#그리디 알고리즘의 정당성

#1. 문제
#준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
#동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오

#2. 입력
#첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
#둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 
#(1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

#3. 코드
n, k = map(int, input().split()) # 동전 종류 수와 총 금액을 split 으로 분리
arr = [] # 동전의 총 가격
cnt = 0 
i = n-1 

for i in range(n):
    arr.append(int(input()))
    
while i >= 0:
    if k >= arr[i]: 
        k -= arr[i] 
        cnt += 1 
    else:
        i -= 1 

print(cnt)
