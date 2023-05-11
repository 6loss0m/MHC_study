"""
    11504 - 돌려 돌려 돌림판!
    처음에 문제 읽는데 이해가 잘 안갔다.. 주어진 예제를 하나하나 천천히 확인하다보니 쉬운 문제였다.
"""


t = int(input())  # 테스트케이스 t개
for _ in range(t) :
    ans = 0 # 출력할 값 초기화

    n, m = map(int, input().split()) # n등분, M자리
    x = int(''.join(list(input().split()))) # x, 입력받은 숫자는 공백을 기준으로 띄어쓰기 되어있기에 join으로 붙여 정수로 만든다.
    y = int(''.join(list(input().split()))) # y, 이하 동일

    roulette = list(map(int, input().split())) # 룰렛의 번호 시간순, 리스트에 값 1개씩 넣어주었다.
    roulette += roulette[:m] # m자리 수만큼 roulette에 더함.

    for i in range(n): # n등분만큼 반복
        check = int(''.join(map(str, roulette[i:i+m]))) # 1~n까지 반복하며 m자리 수를 찾는다.
        if x <= check <= y: # 만약 그 값이 x와 y 사이에 해당한다면
            ans += 1 # 정답이므로 카운트

    print(ans)
