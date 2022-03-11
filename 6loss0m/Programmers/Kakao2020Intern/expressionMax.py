from itertools import permutations

def operation(num1, num2, op):
    if op == '+':
        return str(int(num1) + int(num2))
    if op == '-':
        return str(int(num1) - int(num2))
    if op == '*':
        return str(int(num1) * int(num2))
    
def calculate(exp,op):
    array=[]
    tmp=""
    # 수식 정리
    for i in exp:
        # 숫자인 경우
        if i.isdigit()==True:
            tmp+=i
        # 수식인 경우
        else:
            array.append(tmp)
            array.append(i)
            tmp=""
    # 마지막 숫자 저장
    array.append(tmp)
    
    # 수식 적용
    for o in op:
        stack=[]
        while len(array)!=0:
            tmp=array.pop(0)
            if tmp==o:
                stack.append(operation(stack.pop(), array.pop(0), o))
            else:
                stack.append(tmp)
        array=stack
            
    return abs(int(array[0]))

def solution(expression):
    op = ['+', '-', '*']
    op = list(permutations(op, 3)) # 순열 만들기
    result=[]
    for i in op:
        result.append(calculate(expression, i))
    return max(result)