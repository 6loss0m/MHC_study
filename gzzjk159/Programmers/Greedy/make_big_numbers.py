def solution(number, k):
    # 1. 스택 생성
    st = []

    # 2. 큰 수가 앞자리가 되게끔 스택에 저장합니다.
    for elem in number:
        while st and st[-1] < elem and k > 0: #스택의 마지막 요소와 비교해서 크면 스택에서 빼기
            st.pop()
            k -= 1

        st.append(elem)

    # 3. k가 남았다면 뒤에서부터 뺍니다.
    while k > 0:
        st.pop()
        k-=1

    answer = "".join(st)
    return answer
