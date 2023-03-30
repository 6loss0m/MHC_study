"""
    11256 - 사탕
    첫번 째 줄 - 테스트 케이스 개수
    두번 째 줄 - 사탕의 개수 J, 상자의 개수 N
    세번 째 줄 - i번째 상자의 세로 길이, 가로길이
    ...

    상자를 최소한으로 쓸 때의 사용되는 상자의 개수 출력하는 문제
"""

t = int(input())

for _ in range(t) : # 테스트 케이스 개수만큼 반복
    j, n = map(int, input().split())
    box = [] # 상자 리스트 초기화
    cnt = 0 # 사용할 상자 개수 cnt
    for _ in range(n) : # 상자 개수만큼 반복
        r, c = map(int, input().split())
        box.append(r*c) # 사탕이 들어갈 수 있는 상자의 크기를 box 리스트에 저장
    box.sort(reverse=True) # 내림차순 정렬, 큰 상자부터 사용하는 것이 좋기 때문

    for k in box :
        if j <= 0 : # 남은 사탕 없는 경우
            break
        j -= k # 상자에 넣을 사탕의 개수를 남은 사탕의 개수에서 차감
        cnt += 1 # 상자 cnt
    print(cnt)



