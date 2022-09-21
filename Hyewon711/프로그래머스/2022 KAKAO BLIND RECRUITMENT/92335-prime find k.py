#92335 - k진수에서 소수 개수 구하기

def solution(n, k): # 양의 정수 n, k진수
    word=""
    count = 0
    while n: # 숫자를 k진법으로 변환
        word = str(n % k) + word
        n = n//k

    word=word.split("0") # 변환된 숫자를 0을 기준으로 나눈다.

    for w in word:
        if len(w) == 0: # 만약 0또는 1이거나 빈공간이라면 continue를 통해 건너뛴다.
            continue
        if int(w) < 2:
            continue

        prime=True

        for i in range(2,int(int(w)**0.5)+1): # 에라토스테네스의 체로 소수 판별
            if int(w)%i==0:
                prime = False
                break
        if prime : #소수 개수 1개 추가
            count += 1

    return count