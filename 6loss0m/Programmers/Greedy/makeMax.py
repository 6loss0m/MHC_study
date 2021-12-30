def solution(number, k):
    stack = [number[0]]
    for num in number[1:]:
        # 1. 스택이 채워져 있음
        # 2. top이 현재의 수보다 작음
        # 3. 제외할 숫자가 아직 있음
        while len(stack) > 0 and stack[-1] < num and k > 0:
            k -= 1
            stack.pop()
        stack.append(num)
    print(stack)
    if k != 0:
        stack = stack[:-k]
    return ''.join(stack)